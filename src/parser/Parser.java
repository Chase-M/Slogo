package parser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import command.Command;
import javafx.scene.input.KeyCode;

public class Parser {
    private List<Node> myTreeHeads;
    private int myIndex;
    private ResourceBundle myLanguage;
    private ResourceBundle myCommands;
    private static final String RESOURCE_BUNDLE="resources.languages/";
    private static final String COMMAND_BUNDLE="resources.languages/Command";
    private static final String DEFAULT_LANGUAGE="English";
    public Parser(){
        myTreeHeads=new ArrayList<Node>();
        changeLanguage(DEFAULT_LANGUAGE);
        myCommands=ResourceBundle.getBundle(COMMAND_BUNDLE);
        
    }
    /**
     * takes in a string and parses it by puts all commands into a graph 
     * of Nodes 
     * @param string
     * @return the string used if the commands were successful 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
   public List<Node> parse(String string){
       myTreeHeads.clear();
       string=string.replaceAll("[\\\t|\\\n|\\\r]"," ");
       String[] commands=string.split("\\s+");
       myIndex=0;
       while(myIndex<commands.length){
           myTreeHeads.add(makeTree(commands));
       }
       return myTreeHeads;
   }
   /**
    * If user needs to give mouseinput to parser 
    * @param x
    * @param y
    */
   public void onClick(double x, double y){
       
   }
   /**
    * if user presses a key to give parser info
    * @param key
    */
   public void onKeyPress(KeyCode key){
       
   }
   /**
    * Takes a string to change parser language
    * @param language
    */
   public void changeLanguage(String language){
       myLanguage=ResourceBundle.getBundle(RESOURCE_BUNDLE+language);
   }
   private Node makeTree(String[] s){
       Node node=new Node(makeCommand(s[myIndex]));
       
       myIndex++;
       for(int i=0; i<node.getCommand().getNumInputs(); i++){
           node.addChild(makeTree(s));
       }
       
       return node;
   }
   private Command makeCommand(String command){
       commandFactory factory=new basicCommandCreator();
       Enumeration<String> keys=myLanguage.getKeys();
       String name="Error";
       while(keys.hasMoreElements()){
           String key = (String)keys.nextElement();
           String value = myLanguage.getString(key);
           if(value.contains(command) || ( isRegex(value) && command.matches(value))){
               factory=new basicCommandCreator();
               name=myCommands.getString(key);
           }
       }

       return factory.createCommand(name, command);
}
   public static boolean isRegex(String input) {
       boolean isEx;
       try {
         Pattern.compile(input);
         isEx = true;
       } catch (PatternSyntaxException e) {
         isEx = false;
       }
       return isEx;
   }
  
}
   

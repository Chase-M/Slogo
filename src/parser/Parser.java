package parser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import command.Command;
import javafx.scene.input.KeyCode;

public class Parser {
    private List<Node> myTreeHeads;
    private int myIndex;
    private ResourceBundle myLanguage;
    private static final String RESOURCE_BUNDLE="resources.languages/";
    private static final String DEFAULT_LANGUAGE="English";
    public Parser(){
        myTreeHeads=new ArrayList<Node>();
        changeLanguage(DEFAULT_LANGUAGE);
        
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
       commandFactory factory=null;
       if(isInteger(command)){
           factory=new intCommandCreator();
       }else{
           factory=new basicCommandCreator();
     //      command=myLanguage.getString(command);
       }
       return factory.createCommand(command);
}
   public static boolean isInteger(String s) {
       try { 
           Integer.parseInt(s); 
       } catch(NumberFormatException e) { 
           return false; 
       }
       // only got here if we didn't return false
       return true;
   }
}
   

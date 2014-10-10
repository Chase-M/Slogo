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
    private static final String RESOURCE_BUNDLE="resources.languages";
    private static final String DEFAULT_LANGUAGE="English";
    private static final String COMMAND_PATH="command.";
    public Parser(){
        myTreeHeads=new ArrayList<Node>();
        setLanguage(DEFAULT_LANGUAGE);
        
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
   public List<Node> parse(String string) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
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
       
   }
   private Node makeTree(String[] s) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
       Node node=new Node(makeCommand(s[myIndex]));
       for(int i=0; i<node.getCommand().getNumInputs(); i++){
           myIndex++;
           node.addChild(makeTree(s));
       }
       return node;
   }
   private Command makeCommand(String command) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
       
       String className=COMMAND_PATH+command;
       Class<?> classType=Class.forName(className);
       Command c=(Command)classType.getConstructor().newInstance();
       return c;
               
   }
   public void setLanguage(String language){
       myLanguage=ResourceBundle.getBundle(RESOURCE_BUNDLE+language);
   }
}

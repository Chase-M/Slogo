package parser;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import command.Command;
import command.MakeCommand;
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
     */
   public List<Node> parse(String string){
       myTreeHeads.clear();
       string=string.replaceAll("[\\\t|\\\n|\\\r]"," ");
       String[] commands=string.split("\\s+");
       myIndex=0;
       while(myIndex<commands.length){
           Node n=makeTree(commands);
           myTreeHeads.add(n);

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
       Node node=makeNode(s[myIndex]);
       
       myIndex++;
       Node next=null;
       for(int i=0; i<node.getCommand().getNumInputs(next); i++){
              next=makeTree(s);
              node.addChild(next);          
       }
       
       return node;
   }
   private Node makeNode(String command){
       commandFactory factory=new basicCommandCreator();
       Enumeration<String> keys=myLanguage.getKeys();
       String name="Error";
       while(keys.hasMoreElements()){
           String key = (String)keys.nextElement();
           String value = myLanguage.getString(key);
           if(command.matches(value)){
               factory=new basicCommandCreator();
               name=myCommands.getString(key);
               if(!key.equals("Command")){
                   break;
               }
           }
       }

       return new Node(factory.createCommand(name, command));
}
}   

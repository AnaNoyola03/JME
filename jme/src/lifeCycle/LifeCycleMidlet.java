
package lifeCycle;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;

/**
 * @author ANA_N
 */
public class LifeCycleMidlet extends MIDlet implements CommandListener{
    private Form formulario;
    private Display pantalla;
    private Command cmdExit;
    private StringItem message;
    
    public LifeCycleMidlet(){
        System.out.println("Llamamos a la inicializacion del midlet");
        formulario= new Form("Midlet lifecycle");
        message = new StringItem(null,"Construyendo el midlet");
        formulario.append(message);
        cmdExit = new Command("Salir",Command.EXIT,1);
        formulario.addCommand(cmdExit);
        formulario.setCommandListener(this);
        pantalla = Display.getDisplay(this);
        pantalla.setCurrent(formulario);
    }
    public void startApp() {
        System.out.println("StarApp() is called");
        message.setText("StartApp es llamado...");        
    }
    public void pauseApp() {
        System.out.println("pauseApp() is called");
        message.setText("pauseApp es llamado..."); 
    }
    
    public void destroyApp(boolean unconditional) {
        System.out.println("DestroyApp() is called");
        message.setText("DestroytApp es llamado..."); 
    }

    public void commandAction(Command c, Displayable d) {
      if(c == cmdExit){
          destroyApp(true);
          notifyDestroyed();//To change body of generated methods, choose Tools | Templates.
    }
    }

}

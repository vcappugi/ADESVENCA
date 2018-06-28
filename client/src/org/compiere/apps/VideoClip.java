package org.compiere.apps;

import java.io.File;
import java.awt.Desktop;

import org.compiere.util.Env;

 
@SuppressWarnings({ "unused", "serial" })
public class VideoClip extends File {
    /**
* Constructor de la clase Documento
*   
* @param ruta:   
*          La ruta absoluta del documento   
*/  
 
    public VideoClip(String ruta){
        super(ruta);
    }
 
    /**   
* Ejecuta el documento con la aplicacion   
* predefinida en el sistema.   
*/
    public void ejecutar() throws Exception {
        File archivo = new File(this.getPath());
        //si la clase Desktop es soportada por la plataforma
    //    if(Desktop.isDesktopSupported() == true) {
            //obtengo la instancia de la clase Desktop del entorno actual
    //        Desktop desktop = Desktop.getDesktop();
            if (archivo.toString().startsWith("http"))
            	Env.startBrowser(archivo.toString());
            else {
            	if(archivo.canExecute()) {
                //ejecuto el archivo o URI
    //        		desktop.open(archivo);
            	}else{
            		//sino, lanzo una execpcion con las dos posibles causas de error
            		throw new Exception("No se encontro el archivo " + archivo.getAbsolutePath()+" o no cuenta con permisos para ejecutarlo");
            	}
        }
      //  }else{
            //la clase no es soportada
      //      throw new Exception("No se puede ejecutar el comando de apertura en este sistema operativo");      
      //  }  
    }
}

import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jefry Gutierrez
 */
public class Principal {
    
    
    public static void main(String[]args){
     //obtiene todas la propiedades del sistema en una lista   
      Properties p = System.getProperties();
      p.list(System.out);
      
      //se obtiene la propiedad especifica
      String prpiedad= System.getProperty("os.name");
      System.out.println("Propiedad: "+prpiedad);
      
      /*  
java.runtime.name=Java(TM) SE Runtime Environment
sun.boot.library.path=C:\Program Files\Java\jdk1.8.0_151\jr...
java.vm.version=25.151-b12
java.vm.vendor=Oracle Corporation
java.vendor.url=http://java.oracle.com/
path.separator=;
java.vm.name=Java HotSpot(TM) 64-Bit Server VM
file.encoding.pkg=sun.io
user.script=
user.country=US
sun.java.launcher=SUN_STANDARD
sun.os.patch.level=
java.vm.specification.name=Java Virtual Machine Specification
user.dir=D:\Dropbox\Practicas\Udemy JavaEE\Niv...
java.runtime.version=1.8.0_151-b12
java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment
java.endorsed.dirs=C:\Program Files\Java\jdk1.8.0_151\jr...
os.arch=amd64
java.io.tmpdir=C:\Users\jefry\AppData\Local\Temp\
line.separator=

java.vm.specification.vendor=Oracle Corporation
user.variant=
os.name=Windows 10
sun.jnu.encoding=Cp1252
java.library.path=C:\Program Files\Java\jdk1.8.0_151\bi...
java.specification.name=Java Platform API Specification
java.class.version=52.0
sun.management.compiler=HotSpot 64-Bit Tiered Compilers
os.version=10.0
user.home=C:\Users\jefry
user.timezone=
java.awt.printerjob=sun.awt.windows.WPrinterJob
file.encoding=UTF-8
java.specification.version=1.8
user.name=Jefry Gutierrez
java.class.path=D:\Dropbox\Practicas\Udemy JavaEE\Niv...
java.vm.specification.version=1.8
sun.arch.data.model=64
java.home=C:\Program Files\Java\jdk1.8.0_151\jre
sun.java.command=Principal
java.specification.vendor=Oracle Corporation
user.language=en
awt.toolkit=sun.awt.windows.WToolkit
java.vm.info=mixed mode
java.version=1.8.0_151
java.ext.dirs=C:\Program Files\Java\jdk1.8.0_151\jr...
sun.boot.class.path=C:\Program Files\Java\jdk1.8.0_151\jr...
java.vendor=Oracle Corporation
file.separator=\
java.vendor.url.bug=http://bugreport.sun.com/bugreport/
sun.cpu.endian=little
sun.io.unicode.encoding=UnicodeLittle
sun.desktop=windows
sun.cpu.isalist=amd64
*/    
    }
}

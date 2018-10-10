
package interpreter;

import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private final String Delims = " ";

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {

        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes()  {

        Program program = new Program();
        ArrayList <String> bCodes = new ArrayList();

        try {

            while ((byteSource.readLine() != null)) {

                StringTokenizer tok = new StringTokenizer(byteSource.readLine(), Delims);

                bCodes.clear();

                String className = CodeTable.getClassName(tok.nextToken());

                while (tok.hasMoreTokens()) {

                    bCodes.add(tok.nextToken());
                }

                Class c = Class.forName("byteCodes." + className);
                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();
                bc.init(bCodes);

            }
        }

        catch (IOException|InstantiationException|InvocationTargetException
                |NoSuchMethodException|IllegalAccessException|ClassNotFoundException e) {

            e.printStackTrace();
        }

        program.resolveAddrs();
        return program;
    }
}


import spbu.hw7.task1.Code;
import static org.junit.Assert.*;
import org.junit.Test;

/** Test for Code class. */
public class CodeTest {
    /** Creation test of Code class. */
    @Test
    public void testCreationCode() {
        Code code = new Code();
    }

    /** Test Code class. */
    @Test
    public void testCodeClass() {
        Code code = new Code();
        String actual = code.describeClass(Code.class);

        actual = actual.replace("public class Code {\n", "");
        actual = actual.replace("    public Code();\n", "");

        actual = actual.replace("    public String describeClass(Class arg0);\n", "");
        actual = actual.replace("    private void getClassSpecification(StringBuilder arg0, Class arg1, String arg2);\n", "");
        actual = actual.replace("    private void getClassSignature(StringBuilder arg0, Class arg1);\n", "");
        actual = actual.replace("    private void getFieldSignature(StringBuilder arg0, Class arg1, Field arg2);\n", "");
        actual = actual.replace("    private void getConstructorSignature(StringBuilder arg0, Class arg1, Constructor arg2);\n", "");
        actual = actual.replace("    private void getMethodSignature(StringBuilder arg0, Class arg1, Method arg2);\n", "");
        actual = actual.replace("    private void getParameters(StringBuilder arg0, Parameter[] arg1);\n", "");
        actual = actual.replace("    private boolean isNumber(String arg0);\n", "");
        actual = actual.replace("    private void checkBlock(StringBuilder arg0, boolean arg1, int arg2);\n", "");
        actual = actual.replace("}\n", "");

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");
        assertEquals("Incorrect description of Code()", "", actual);
    }

    /** Test ExampleSuperClass class. */
    @Test
    public void testExampleSuperClass() {
        Code code = new Code();
        String actual = code.describeClass(ExampleSuperClass.class);

        actual = actual.replace("public class ExampleSuperClass {\n", "");
        actual = actual.replace("    public ExampleSuperClass();\n", "");

        actual = actual.replace("    public String publicString();\n", "");
        actual = actual.replace("    protected void protectedVoid();\n", "");
        actual = actual.replace("    private void privateVoid();\n", "");
        actual = actual.replace("}\n", "");

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");
        assertEquals("Incorrect description of ExampleSuperClass()", "", actual);
    }

    /** Test ExampleClass class. */
    @Test
    public void testExampleClass() {
        Code code = new Code();
        String actual = code.describeClass(ExampleClass.class);

        actual = actual.replace("public abstract class ExampleClass extends ExampleSuperClass implements FirstExampleInterface, SecondExampleInterface {\n", "");
        actual = actual.replace("    public String stringField;\n", "");
        actual = actual.replace("    protected Float floatField;\n", "");
        actual = actual.replace("    private final String FINAL_STRING;\n", "");

        actual = actual.replace("    public ExampleClass(Float arg0);\n", "");
        actual = actual.replace("    protected ExampleClass();\n", "");

        actual = actual.replace("    public char charFunction();\n", "");
        actual = actual.replace("    protected abstract String toDoSomething(String arg0, int arg1);\n", "");

        actual = actual.replace("    private class Node {\n", "");
        actual = actual.replace("        public int intField;\n", "");

        actual = actual.replace("        public Node(ExampleClass arg0);\n", "");

        actual = actual.replace("        public void setIntField(int arg0);\n", "");
        actual = actual.replace("    }\n", "");
        actual = actual.replace("    private class OtherNode {\n", "");
        actual = actual.replace("        private int firstIntField;\n", "");
        actual = actual.replace("        private int secondIntField;\n", "");
        actual = actual.replace("        private final int FINAL_INT;\n", "");

        actual = actual.replace("        private OtherNode(ExampleClass arg0);\n", "");

        actual = actual.replace("        private class EnclosedClass {\n", "");
        actual = actual.replace("            private EnclosedClass(OtherNode arg0);\n", "");
        actual = actual.replace("        }\n", "");
        actual = actual.replace("    }\n", "");
        actual = actual.replace("}\n", "");

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");
        assertEquals("Incorrect description of ExampleClass()", "", actual);
    }

    /** Test FirstExampleInterface interface. */
    @Test
    public void testFirstExampleInterface() {
        Code code = new Code();
        String actual = code.describeClass(FirstExampleInterface.class);

        actual = actual.replace("public interface FirstExampleInterface {\n", "");
        actual = actual.replace("    public final int INTERFACE_FINAL_INT;\n", "");

        actual = actual.replace("    public char charFunction();\n", "");
        actual = actual.replace("}\n", "");

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");
        assertEquals("Incorrect description of FirstExampleInterface()", "", actual);
    }

    /** Test SecondExampleInterface interface. */
    @Test
    public void testSecondExampleInterface() {
        Code code = new Code();
        String actual = code.describeClass(SecondExampleInterface.class);
        System.out.println(actual);

        actual = actual.replace("public interface SecondExampleInterface {\n", "");
        actual = actual.replace("    public int interfaceIntFunction(float arg0);\n", "");
        actual = actual.replace("}\n", "");

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");
        assertEquals("Incorrect description of SecondExampleInterface()", "", actual);
    }

    /** Test CodeTest class. */
    @Test
    public void testCodeTest() {
        Code code = new Code();
        String actual = code.describeClass(CodeTest.class);

        actual = actual.replace("public class CodeTest {\n", "");
        actual = actual.replace("    public CodeTest();\n", "");

        actual = actual.replace("    public void testCreationCode();\n", "");
        actual = actual.replace("    public void testCodeClass();\n", "");
        actual = actual.replace("    public void testExampleSuperClass();\n", "");
        actual = actual.replace("    public void testExampleClass();\n", "");
        actual = actual.replace("    public void testFirstExampleInterface();\n", "");
        actual = actual.replace("    public void testSecondExampleInterface();\n", "");
        actual = actual.replace("    public void testCodeTest();\n", "");
        actual = actual.replace("}\n", "");

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");
        assertEquals("Incorrect description of CodeTest()", "", actual);
    }
}
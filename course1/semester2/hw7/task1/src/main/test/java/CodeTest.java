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
        String[] expected = new String[]{
                "public class Code {\n",
                "    public Code();\n",

                "    public String describeClass(Class arg0);\n",
                "    private void getClassSpecification(StringBuilder arg0, Class arg1, String arg2);\n",
                "    private void getClassSignature(StringBuilder arg0, Class arg1);\n",
                "    private void getFieldSignature(StringBuilder arg0, Class arg1, Field arg2);\n",
                "    private void getConstructorSignature(StringBuilder arg0, Class arg1, Constructor arg2);\n",
                "    private void getMethodSignature(StringBuilder arg0, Class arg1, Method arg2);\n",
                "    private void getParameters(StringBuilder arg0, Parameter[] arg1);\n",
                "    private boolean isNumber(String arg0);\n",
                "    private void checkBlock(StringBuilder arg0, boolean arg1, int arg2);\n",
                "}\n"
        };

        assertReplacementStrings("Incorrect description of Code()", expected, actual);
    }


    /** Test ExampleSuperClass class. */
    @Test
    public void testExampleSuperClass() {
        Code code = new Code();
        String actual = code.describeClass(ExampleSuperClass.class);
        String[] expected = new String[]{
                "public class ExampleSuperClass {\n",
                "    public ExampleSuperClass();\n",

                "    public String publicString();\n",
                "    protected void protectedVoid();\n",
                "    private void privateVoid();\n",
                "}\n"
        };

        assertReplacementStrings("Incorrect description of ExampleSuperClass()", expected, actual);
    }

    /** Test ExampleClass class. */
    @Test
    public void testExampleClass() {
        Code code = new Code();
        String actual = code.describeClass(ExampleClass.class);
        String[] expected = new String[]{
                "public abstract class ExampleClass extends ExampleSuperClass implements FirstExampleInterface, SecondExampleInterface {\n",
                "    public String stringField;\n",
                "    protected Float floatField;\n",
                "    private final String FINAL_STRING;\n",

                "    public ExampleClass(Float arg0);\n",
                "    protected ExampleClass();\n",

                "    public char charFunction();\n",
                "    protected abstract String toDoSomething(String arg0, int arg1);\n",

                "    private class OtherNode {\n",
                "        private int firstIntField;\n",
                "        private int secondIntField;\n",
                "        private final int FINAL_INT;\n",

                "        private OtherNode(ExampleClass arg0);\n",

                "        private class EnclosedClass {\n",
                "            private EnclosedClass(OtherNode arg0);\n",
                "        }\n",
                "    }\n",
                "    private class Node {\n",
                "        public int intField;\n",

                "        public Node(ExampleClass arg0);\n",

                "        public void setIntField(int arg0);\n",
                "}\n"
        };

        assertReplacementStrings("Incorrect description of ExampleClass()", expected, actual);
    }

    /** Test FirstExampleInterface interface. */
    @Test
    public void testFirstExampleInterface() {
        Code code = new Code();
        String actual = code.describeClass(FirstExampleInterface.class);
        String[] expected = new String[]{
                "public interface FirstExampleInterface {\n",
                "    public final int INTERFACE_FINAL_INT;\n",

                "    public char charFunction();\n",
                "}\n"
        };

        assertReplacementStrings("Incorrect description of FirstExampleInterface()", expected, actual);
    }

    /** Test SecondExampleInterface interface. */
    @Test
    public void testSecondExampleInterface() {
        Code code = new Code();
        String actual = code.describeClass(SecondExampleInterface.class);
        String[] expected = new String[]{
                "public interface SecondExampleInterface {\n",
                "    public int interfaceIntFunction(float arg0);\n",
                "}\n"
        };

        assertReplacementStrings("Incorrect description of SecondExampleInterface()", expected, actual);
    }

    /** Test CodeTest class. */
    @Test
    public void testCodeTest() {
        Code code = new Code();
        String actual = code.describeClass(CodeTest.class);
        String[] expected = new String[]{
                "public class CodeTest {\n",
                "    public CodeTest();\n",

                "    public void testCreationCode();\n",
                "    public void testCodeClass();\n",
                "    public void testExampleSuperClass();\n",
                "    public void testExampleClass();\n",
                "    public void testFirstExampleInterface();\n",
                "    public void testSecondExampleInterface();\n",
                "    public void testCodeTest();\n",
                "    private void assertReplacementStrings(String arg0, String[] arg1, String arg2);\n",
                "    private String replaceString(String arg0, String arg1);\n",
                "}\n"
        };

        assertReplacementStrings("Incorrect description of CodeTest()", expected, actual);
    }

    private void assertReplacementStrings(String message, String[] expected, String actual) {
        for (int i = 0; i < expected.length; i++) {
            actual = replaceString(actual, expected[i]);
            assertFalse(message, actual == null);
        }

        actual = actual.replace(" ", "");
        actual = actual.replace("\n", "");

        assertEquals(message, "", actual);
    }

    private String replaceString(String string, String subString) {
        if (!string.contains(subString)) {
            return null;
        }

        string = string.replace(subString, "");
        return string;
    }
}
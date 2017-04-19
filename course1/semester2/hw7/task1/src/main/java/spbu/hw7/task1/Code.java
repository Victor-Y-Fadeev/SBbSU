package spbu.hw7.task1;

import java.lang.reflect.*;

/** Get code of class. */
public class Code {
    /**
     * Get class specification.
     *
     * @return  Result of scanning
     * */
    public String describeClass(Class clazz) {
        return getClassSpecification(clazz, "");
    }

    private String getClassSpecification(Class clazz, String tab) {
        String result = tab + getClassSignature(clazz) + "{\n";
        boolean indent = false;

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (!isNumber(fields[i].getName().replace("this$", ""))) {
                result += tab + "    " + getFieldSignature(clazz, fields[i]) + "\n";
                indent = true;
            }
        }

        Constructor[] constructors = clazz.getDeclaredConstructors();
        if (indent && (constructors.length != 0)) {
            result += "\n";
        }
        for (int i = 0; i < constructors.length; i++) {
            result += tab + "    " + getConstructorSignature(clazz, constructors[i]) + "\n";
            indent = true;
        }

        Method[] methods = clazz.getDeclaredMethods();
        if (indent && (methods.length != 0)) {
            result += "\n";
        }
        for (int i = 0; i < methods.length; i++) {
            result += tab + "    " + getMethodSignature(clazz, methods[i]) + "\n";
            indent = true;
        }

        Class[] classes = clazz.getDeclaredClasses();
        if (indent && (classes.length != 0)) {
            result += "\n";
        }
        for (int i = 0; i < classes.length; i++) {
            result += getClassSpecification(classes[i], tab + "    ");
        }

        result += tab + "}\n";
        return result;
    }

    private String getClassSignature(Class clazz) {
        String result = Modifier.toString(clazz.getModifiers()) + " ";

        if (clazz.isInterface()) {
            result = result.replace("abstract ", "");
        } else {
            result += "class ";
        }

        result += clazz.getSimpleName() + " ";

        if ((clazz.getSuperclass() != null) && !clazz.getSuperclass().equals(Object.class)) {
            result += "extends " + clazz.getSuperclass().getSimpleName() + " ";
        }

        if (clazz.getInterfaces().length != 0) {
            Class[] interfaces = clazz.getInterfaces();
            result += "implements " + interfaces[0].getSimpleName();

            for (int i = 1; i < interfaces.length; i++) {
                result += ", " + interfaces[i].getSimpleName();
            }

            result += " ";
        }

        return result;
    }

    private String getFieldSignature(Class clazz, Field field) {
        String result = Modifier.toString(field.getModifiers()) + " ";

        if (clazz.isInterface()) {
            result = result.replace("static ", "");
        }

        result += field.getType().getSimpleName() + " ";
        result += field.getName() + ";";

        return result;
    }

    private String getConstructorSignature(Class clazz, Constructor constructor) {
        String result = Modifier.toString(constructor.getModifiers()) + " ";

        result += clazz.getSimpleName() + "(";
        result += getParameters(constructor.getParameters());
        result += ");";

        return result;
    }

    private String getMethodSignature(Class clazz, Method method) {
        String result = Modifier.toString(method.getModifiers()) + " ";

        if (clazz.isInterface()) {
            result = result.replace("abstract ", "");
        }

        result += method.getReturnType().getSimpleName() + " ";
        result += method.getName() + "(";
        result += getParameters(method.getParameters());
        result += ");";

        return result;
    }

    private String getParameters(Parameter[] parameters) {
        if (parameters.length == 0) {
            return "";
        }

        String result = parameters[0].getType().getSimpleName() + " " + parameters[0].getName();
        for (int i = 1; i < parameters.length; i++) {
            result += ", " + parameters[i].getType().getSimpleName() + " " + parameters[i].getName();
        }

        return result;
    }

    private boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
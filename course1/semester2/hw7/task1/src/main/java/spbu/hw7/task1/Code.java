package spbu.hw7.task1;

import java.lang.reflect.*;

/** Get code of class. */
public class Code {
    private Class clazz;

    public Code(Class clazz) {
        this.clazz = clazz;
    }

    public String output() {
        return getClassSpecification(clazz, "");
    }

    public String getClassSpecification(Class clazz, String tab) {
        String result = tab + getClassSignature(clazz) + "{\n";
        boolean indent = false;

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getName().equals("this$0")) {
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

        if (method.getParameters().length != 0) {
            Parameter[] parameters = method.getParameters();
            result += parameters[0].getType().getSimpleName() + " " + parameters[0].getName();

            for (int i = 1; i < parameters.length; i++) {
                result += ", " + parameters[i].getType().getSimpleName() + " " + parameters[i].getName();
            }
        }
        result += ");";

        return result;
    }
}
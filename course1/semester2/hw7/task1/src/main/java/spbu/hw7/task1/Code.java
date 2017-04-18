package spbu.hw7.task1;

import java.lang.reflect.Modifier;

/** Get code of class. */
public class Code {
    public Class clazz;

    public Code(Class clazz) {
        this.clazz = clazz;
    }

    public String output() {
        String result = "";

        if (Modifier.isPublic(clazz.getModifiers())) {
            result += "public ";
        } else if (Modifier.isProtected(clazz.getModifiers())) {
            result += "protected ";
        } else if (Modifier.isPrivate(clazz.getModifiers())) {
            result += "private ";
        }

        if (clazz.isInterface()) {
            result += "interface ";
        } else {
            if (Modifier.isAbstract(clazz.getModifiers())) {
                result += "abstract ";
            }

            result += "class ";
        }

        result += clazz.getSimpleName() + " ";

        if (clazz.getSuperclass() != null) {
            result += "extends " + clazz.getSuperclass().getSimpleName() + " ";
        }

        if (clazz.getInterfaces() != null) {
            Class[] interfaces = clazz.getInterfaces();
            result += "implements " + interfaces[0].getSimpleName();

            for (int i = 1; i < interfaces.length; i++) {
                result += ", " + interfaces[i].getSimpleName();
            }

            result += " ";
        }

        result += "{\n}\n";
        return result;
    }
}
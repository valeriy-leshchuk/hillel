package hw.sixteen;

import hw.utils.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Set;

import static hw.sixteen.JsonUtils.getOrCreateArray;

public interface ICodeAnalyzer
{
    String JSON_MODIFIERS = "modifiers";
    String JSON_NAME = "name";
    String JSON_FIELDS = "fields";
    String JSON_ANNOTATIONS = "annotations";
    String JSON_PARAMS = "params";
    String JSON_METHODS = "methods";
    String JSON_CONSTRUCTORS = "constructors";

    default JSONObject analyzeClass(Class<?> clazz)
    {
        if (clazz.getDeclaredAnnotation(Analyzable.class) != null)
        {
            JSONObject json = new JSONObject();

            Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
                if (field.getAnnotation(Analyzable.class) != null)
                {
                    JSONArray fieldsJsonArray = getOrCreateArray(json, JSON_FIELDS);
                    JSONObject jsonField = new JSONObject();
                    Set<String> modifiers = ReflectionUtils.getModifiersAsSet(field);
                    String name = field.getName();
                    Set<String> annotations = ReflectionUtils.getAnnotationsAsSet(field);
                    jsonField.put(JSON_MODIFIERS, modifiers).put(JSON_NAME, name).put(JSON_ANNOTATIONS, annotations);
                    fieldsJsonArray.put(jsonField);
                }
            });

            Arrays.stream(clazz.getDeclaredConstructors()).forEach(constructor -> {
                if (constructor.getDeclaredAnnotation(Analyzable.class) != null)
                {
                    JSONArray constructorsJsonArray = getOrCreateArray(json, JSON_CONSTRUCTORS);
                    JSONObject jsonConstr = new JSONObject();
                    Set<String> modifiers = ReflectionUtils.getModifiersAsSet(constructor);
                    Set<String> params = ReflectionUtils.getParamsAsSet(constructor);
                    Set<String> annotations = ReflectionUtils.getAnnotationsAsSet(constructor);
                    jsonConstr.put(JSON_MODIFIERS, modifiers).put(JSON_PARAMS, params).put(JSON_ANNOTATIONS, annotations);
                    constructorsJsonArray.put(jsonConstr);
                }
            });

            Arrays.stream(clazz.getDeclaredMethods()).forEach(method -> {
                if (method.getDeclaredAnnotation(Analyzable.class) != null)
                {
                    JSONArray methodsJsonArray = getOrCreateArray(json, JSON_METHODS);
                    JSONObject jsonMethod = new JSONObject();
                    Set<String> modifiers = ReflectionUtils.getModifiersAsSet(method);
                    String name = method.getName();
                    Set<String> params = ReflectionUtils.getParamsAsSet(method);
                    Set<String> annotations = ReflectionUtils.getAnnotationsAsSet(method);
                    jsonMethod.put(JSON_MODIFIERS, modifiers).put(JSON_NAME, name).put(JSON_PARAMS, params).put(JSON_ANNOTATIONS, annotations);
                    methodsJsonArray.put(jsonMethod);
                }
            });

            return json;
        }
        else
        {
            Logger.getLogger().info("Class is not annotated with " + Analyzable.class);
            return null;
        }
    }
}

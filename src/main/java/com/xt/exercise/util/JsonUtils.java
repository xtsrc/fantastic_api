package com.xt.exercise.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.collect.Lists;

public final class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.disable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        mapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.getSerializerProvider().setNullKeySerializer(new MyDtoNullKeySerializer());

        mapper.setSerializationInclusion(Include.NON_EMPTY); // 序列化不需要null的
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static String encode(Object data) {
        try {
            return mapper.writeValueAsString(data);
        } catch (Exception e) {
            return null;
        }
    }

    public static <K, V> Map<K, V> decodeMap(String json, TypeReference<Map<K, V>> ref) {
        try {
            return (Map) mapper.readValue(json, ref);
        } catch (Exception e) {
            throw new RuntimeException("序列化失败", e);
        }
    }

    public static <T> T decode(String content, Class<T> toValueType) {
        try {
            if (StringUtils.isEmpty(content)) {
                return null;
            }
            return mapper.readValue(content, toValueType);
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonNode transToNode(String content) throws IOException {
        return mapper.readTree(content);
    }

    public static String getAsString(String content, String path) throws IOException {
        JsonNode root = mapper.readTree(content);
        JsonNode targetNode = root.get(path);
        if (targetNode != null) {
            return targetNode.asText();
        }
        return null;
    }

    public static double atAsDouble(String content, String path) throws IOException {
        JsonNode root = mapper.readTree(content);
        JsonNode targetNode = root.at(path);
        if (targetNode != null) {
            return targetNode.asDouble();
        }
        return 0L;
    }

    public static String atAsString(String content, String path) throws IOException {
        JsonNode root = mapper.readTree(content);
        JsonNode targetNode = root.at(path);
        if (targetNode != null) {
            return targetNode.asText();
        }
        return "";
    }

    public static Long getAsLong(String content, String path) throws IOException {
        JsonNode root = mapper.readTree(content);
        JsonNode targetNode = root.at(path);
        if (targetNode != null) {
            return targetNode.asLong();
        }
        return 0L;
    }

    public static JsonNode getJson(Object object) {
        try {
            String json = mapper.writeValueAsString(object);
            return mapper.readTree(json);
        } catch (IOException e) {
            throw new IllegalArgumentException("序列化异常");
        }
    }

    public static <T> List<T> getAsList(String json, Class<T> elementClass) throws IOException {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, elementClass);
        return mapper.readValue(json, javaType);
    }

    public static int getListCount(String content, String path) throws IOException {
        JsonNode root = mapper.readTree(content);
        JsonNode targetNode = root.at(path);
        if (targetNode == null) {
            return 0;
        }
        return targetNode.size();
    }

    public static <T> List<T> getAsList(String json, String path, Class<T> elementClass) throws IOException {
        JsonNode root = mapper.readTree(json);
        JsonNode targetNode = root.at(path);
        if (targetNode == null) {
            return Lists.newArrayList();
        }
        if (targetNode.isNull()) {
            return Lists.newArrayList();
        }
        String targetString = targetNode.toString();
        if (StringUtils.isEmpty(targetString)) {
            return Lists.newArrayList();
        }
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, elementClass);
        return mapper.readValue(targetString, javaType);
    }

    private static class MyDtoNullKeySerializer extends StdSerializer<Object> {

        private static final long serialVersionUID = 3024090892228000517L;

        MyDtoNullKeySerializer() {
            this(null);
        }

        MyDtoNullKeySerializer(Class<Object> t) {
            super(t);
        }

        @Override
        public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused)
                throws IOException {
            jsonGenerator.writeFieldName("");
        }

    }

}

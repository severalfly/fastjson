package com.alibaba.json.bvt.serializer.stream;

import java.io.StringWriter;

import org.junit.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.json.SerializeWriterTestUtils;


public class StreamWriterTest_writeFieldValue_string_singQuote extends TestCase {
    public void test_0() throws Exception {
        StringWriter out = new StringWriter();
        
        SerializeWriter writer = new SerializeWriter(out, 10);
        writer.config(SerializerFeature.QuoteFieldNames, true);
        writer.config(SerializerFeature.UseSingleQuotes, true);
        Assert.assertEquals(10, SerializeWriterTestUtils.getBufferLength(writer));
        
        writer.writeFieldValue(',', "abcde01245abcde", "123");
        writer.close();
        
        String text = out.toString();
        Assert.assertEquals(",'abcde01245abcde':'123'", text);
    }
}

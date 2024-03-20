package com.example;

import org.apache.commons.io.IOUtils;
import org.cyclonedx.BomParserFactory;
import org.cyclonedx.model.Bom;
import org.cyclonedx.parsers.Parser;
import org.junit.jupiter.api.Test;

import java.net.URL;

public class CycloneDxTest {

    @Test
    public void testParseBom() throws Exception {
        URL url = this.getClass().getResource("/sbom-demo-1.0.0-SNAPSHOT-cyclonedx.json");
        byte[] bytes = IOUtils.toByteArray(url);
        Parser parser = BomParserFactory.createParser(bytes);
        Bom bom = parser.parse(bytes);
        System.out.println(bom.getMetadata().getComponent().getDescription());
    }
}

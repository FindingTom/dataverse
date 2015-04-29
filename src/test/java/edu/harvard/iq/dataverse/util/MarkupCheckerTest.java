/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.harvard.iq.dataverse.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rmp553
 */
public class MarkupCheckerTest {
    
    public MarkupCheckerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    private void msg(String s){
        System.out.println(s);
    }
    private void msgu(String s){
        msg("--------------------------------------");
        msg(s);
    }    
    /**
     * Test of sanitizeBasicHTML method, of class MarkupChecker.
     */
    @Test
    public void testSanitizeBasicHTML() {
        System.out.println("sanitizeBasicHTML");
        
        String safeStr = "<img src=\"some/png.png\" alt=\"bee\" class=\"some-class\">";
        String sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(safeStr.equals(sanitized));

        safeStr = "<script>alert('hi')</script>";
        sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(sanitized.equals(""));

        String unsafeStr = "<map name=\"rtdcCO\">";
        safeStr = "<map name=\"rtdcCO\"></map>";
        sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(safeStr.equals(sanitized));

        unsafeStr = "<area shape=\"rect\" coords=\"42,437,105,450\" href=\"/dvn/dv/rtdc/faces/study/StudyPage.xhtml?globalId=hdl:10904/10006\" title=\"Galactic Center (DHT02)\" alt=\"Galactic Center (DHT02)\">";
        safeStr = unsafeStr;//"<map name=\"rtdcCO\"></map>";
        sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(safeStr.equals(sanitized));

        
        unsafeStr = "<map name=\"rtdcCO\"><area shape=\"rect\" coords=\"42,437,105,450\" href=\"/dvn/dv/rtdc/faces/study/StudyPage.xhtml?globalId=hdl:10904/10006\" title=\"Galactic Center (DHT02)\" alt=\"Galactic Center (DHT02)\"></map>";
        safeStr = unsafeStr;//"<map name=\"rtdcCO\"></map>";
        sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(safeStr.equals(sanitized));

        unsafeStr = "<p>hello</";
        safeStr = "hello";//"<map name=\"rtdcCO\"></map>";
        sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(safeStr.equals(sanitized));

        unsafeStr = "<h1>hello</h2>";
        safeStr = "hello";//"<map name=\"rtdcCO\"></map>";
        sanitized = MarkupChecker.sanitizeBasicHTML(safeStr);
        this.msgu("safeStr: " + safeStr + "\nsanitized: " + sanitized);
        assertTrue(safeStr.equals(sanitized));

    }

    /**
     * Test of stripAllTags method, of class MarkupChecker.
     */
    @Test
    public void testStripAllTags() {
        /*
        System.out.println("stripAllTags");
        String unsafe = "";
        String expResult = "";
        String result = MarkupChecker.stripAllTags(unsafe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
                */
    }
    
}

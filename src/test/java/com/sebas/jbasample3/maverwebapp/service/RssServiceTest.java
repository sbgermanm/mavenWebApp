/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.service;

import com.sebas.jbasample3.maverwebapp.entity.Item;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sgerman
 */
public class RssServiceTest {
     
    RssService rssService;

    public RssServiceTest() {
    }
    
    @Before
    public void setUp() {
        rssService = new RssService();
    }

    /**
     * Test of getItems method, of class RssService.
     */
    @Test
    public void testGetItems_File() throws Exception {
        
                List<Item> items = rssService.getItems(new File("src/test/resources/JavaVids_rss.xml"));
        Assert.assertEquals(10, items.size());
        Item temporal = items.get(0);
        Assert.assertEquals("How to solve Source not found error during debug in Eclipse", temporal.getTitle());
        String format = new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(temporal.getPublishDate());
        System.err.println(format);
        Assert.assertEquals("22 06 2014 22:35:49", format);

    }

    /**
     * Test of getItems method, of class RssService.
     */
    @Test
    public void testGetItems_String() throws Exception {
    }
    
}

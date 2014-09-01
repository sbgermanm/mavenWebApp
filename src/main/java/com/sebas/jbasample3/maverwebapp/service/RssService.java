/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample3.maverwebapp.service;

import com.sebas.jbasample3.maverwebapp.entity.Item;
import com.sebas.jbasample3.maverwebapp.exceptions.RssException;
import com.sebas.jbasample3.maverwebapp.rss.ObjectFactory;
import com.sebas.jbasample3.maverwebapp.rss.TRss;
import com.sebas.jbasample3.maverwebapp.rss.TRssChannel;
import com.sebas.jbasample3.maverwebapp.rss.TRssItem;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author sgerman
 */
@Service
public class RssService {

    public List<Item> getItems(File f) throws RssException {
        return getItems(new StreamSource(f));
    }
    
    public List<Item> getItems(String url) throws RssException {
        return getItems(new StreamSource(url));
    }
    
//  Un metodo que devuelve una lista de items desde un Source. 
//  El unmarshaller puede usar Source, File, URL, etc, para hacerlo mas generico, lo dejamos como Source
//  y fuera de el creamos un source desde un file o url
//  Lanza una excepcion propia para capturar las que salgan aqui
    private List<Item> getItems(Source source) throws RssException {
        ArrayList<Item> list = new ArrayList<Item>();
        try {
//                    1. crear un JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
//                    2. crear un unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//                    3. parsear el RssFedd
            JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
//                    4. El elemento padre de un rssFeed es el TRss    
            TRss rss = jaxbElement.getValue();
//                    5. dentro de TRss hay canales
            List<TRssChannel> channels = rss.getChannel();
            for (TRssChannel channel : channels) {
//                    6. dentro de cada canal, estan los items
                List<TRssItem> items = channel.getItem();
                for (TRssItem rssItem : items) {
//		      7. ya podemos extraer la info para nuestros items entities
                    Item item = new Item();
                    item.setTitle(rssItem.getTitle());
                    item.setDescripcion(rssItem.getDescription());
                    item.setLink(rssItem.getLink());
//                    8. la fecha en los feeds llevan este formato
                    Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(rssItem.getPubDate());
                    item.setPublishDate(pubDate);
                    list.add(item);
                }
            }
        } catch (JAXBException e) {
            throw new RssException(e);
        } catch (ParseException e) {
            throw new RssException(e);
        }
        return list;
    }
}

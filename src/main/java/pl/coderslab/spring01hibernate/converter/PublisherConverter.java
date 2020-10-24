package pl.coderslab.spring01hibernate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Publisher;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    PublisherDao publisherDao;

    @Override
    public Publisher convert(String publisherId) {
        return publisherDao.findById(Long.parseLong(publisherId));
    }
}

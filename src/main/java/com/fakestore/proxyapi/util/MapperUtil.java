package com.fakestore.proxyapi.util;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MapperUtil {

    private final ApplicationContext applicationContext;

    /*
    @Qualifier("productMapper")
    private final ModelMapper modelMapper;*/

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, String... mapperQualifier) {

        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .toList();
    }

    public <S,T> T map(S source, Class<T> targetClass, String... mapperQualifier) {

        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return modelMapper.map(source, targetClass);
    }

    private ModelMapper getModelMapper(String... mapperQualifier) {
        if (mapperQualifier.length == 0 || mapperQualifier[0] == null) {
            return applicationContext.getBean("defaultMapper", ModelMapper.class);
        } else {
            return applicationContext.getBean(mapperQualifier[0], ModelMapper.class);
        }
    }
}

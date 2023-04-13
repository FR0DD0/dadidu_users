package com.makiia.modules.users.usecase;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimaDto;
import com.makiia.modules.bus.services.UseCase;
import com.makiia.modules.bus.services.UsecaseServices;
import com.makiia.modules.users.dataproviders.jpa.JpaEntyRecmaesusuarimaDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
@Log4j2
@UseCase
public class EntyRecmaesusuarimaService extends UsecaseServices<EntyRecmaesusuarimaDto, JpaEntyRecmaesusuarimaDataProviders> {
    @Autowired
    private JpaEntyRecmaesusuarimaDataProviders jpaDataProviders;
    @PostConstruct
    public void init() {
        this.ijpaDataProvider = jpaDataProviders;
    }
}

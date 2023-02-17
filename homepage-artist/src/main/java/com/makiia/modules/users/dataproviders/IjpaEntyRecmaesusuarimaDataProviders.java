package com.makiia.modules.users.dataproviders;

import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimaDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.modules.bus.contracts.IjpaDataProviders;

public interface IjpaEntyRecmaesusuarimaDataProviders extends IjpaDataProviders<EntyRecmaesusuarimaDto> {
    EntyRecmaesusuarimaDto update(String id, EntyRecmaesusuarimaDto dto) throws EBusinessException;
    void delete(String id) throws EBusinessException;

}

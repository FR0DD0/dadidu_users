package com.makiia.modules.users.dataproviders.jpa;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimaDto;
import com.makiia.crosscutting.exceptions.DataProvider;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarima;
import com.makiia.crosscutting.persistence.repository.EntyRecmaesusuarimaRepository;
import com.makiia.modules.users.dataproviders.IjpaEntyRecmaesusuarimaDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
@DataProvider
public class JpaEntyRecmaesusuarimaDataProviders implements IjpaEntyRecmaesusuarimaDataProviders{
  @Autowired
    private EntyRecmaesusuarimaRepository repository;
    @Autowired
    @Qualifier("entyRecmaesusuarimaSaveResponseTranslate")
    private Translator<EntyRecmaesusuarima, EntyRecmaesusuarimaDto> saveResponseTranslate;

    @Autowired
    @Qualifier("entyRecmaesusuarimaDtoToEntityTranslate")
    private  Translator<EntyRecmaesusuarimaDto, EntyRecmaesusuarima> dtoToEntityTranslate;

    @Override
    public List<EntyRecmaesusuarimaDto> getAll() throws EBusinessException {
        List<EntyRecmaesusuarimaDto> dtos = new ArrayList<>();
        try {
            List<EntyRecmaesusuarima> responses = (List<EntyRecmaesusuarima>) repository.findAll();
            if (!responses.isEmpty()) {
                for (EntyRecmaesusuarima response : responses) {
                    dtos.add(saveResponseTranslate.translate(response));
                }
            }
            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaesusuarimaDto get(String id) throws EBusinessException {
        try{
            return  saveResponseTranslate.translate(repository.findById(id).get());
        }
        catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }
    @Override
    public EntyRecmaesusuarimaDto save(EntyRecmaesusuarimaDto dto) throws EBusinessException {
        try{
            return saveResponseTranslate.translate(repository.save(dtoToEntityTranslate.translate(dto)));
          }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public List<EntyRecmaesusuarimaDto> save(List<EntyRecmaesusuarimaDto> dtos) throws EBusinessException {
        try{
            List<EntyRecmaesusuarima> entities = new ArrayList<>();
            for(EntyRecmaesusuarimaDto dto : dtos){
                entities.add(dtoToEntityTranslate.translate(dto));
            }
            dtos = new ArrayList<>();
            for (EntyRecmaesusuarima entity: repository.saveAll(entities)){
                dtos.add(saveResponseTranslate.translate(entity));
            }
            return  dtos;
        }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaesusuarimaDto update(String id, EntyRecmaesusuarimaDto dto) throws EBusinessException {
        try{

            EntyRecmaesusuarima entity = dtoToEntityTranslate.translate(dto);
            EntyRecmaesusuarima old = repository.findById(id).get();

            old.setRecNroregReus(
                    Objects.nonNull(dto.getRecNroregReus()) && !entity.getRecNroregReus().isEmpty()
                    ? entity.getRecNroregReus()
                    : old.getRecNroregReus());
            old.setRecNiknamReus(
                    Objects.nonNull(dto.getRecNiknamReus()) && !entity.getRecNiknamReus().isEmpty()
                            ? entity.getRecNiknamReus()
                            : old.getRecNiknamReus());
            old.setRecNroideReus(
                    Objects.nonNull(dto.getRecNroideReus()) && !entity.getRecNroideReus().equals(0)
                            ? entity.getRecNroideReus()
                            : old.getRecNroideReus());
            old.setRecNombreReus(
                    Objects.nonNull(dto.getRecNombreReus()) && !entity.getRecNombreReus().isEmpty()
                            ? entity.getRecNombreReus()
                            : old.getRecNombreReus());
            old.setRecApelidReus(
                    Objects.nonNull(dto.getRecApelidReus()) && !entity.getRecApelidReus().isEmpty()
                            ? entity.getRecApelidReus()
                            : old.getRecApelidReus());
            old.setRecFecnacReus(
                    Objects.nonNull(dto.getRecFecnacReus()) && !entity.getRecFecnacReus().isEmpty()
                            ? entity.getRecFecnacReus()
                            : old.getRecFecnacReus());
            old.setRecSexusuReus(
                    Objects.nonNull(dto.getRecSexusuReus()) && !entity.getRecSexusuReus().isEmpty()
                            ? entity.getRecSexusuReus()
                            : old.getRecSexusuReus());
            old.setRecNomusuReus(
                    Objects.nonNull(dto.getRecNomusuReus()) && !entity.getRecNomusuReus().isEmpty()
                            ? entity.getRecNomusuReus()
                            : old.getRecNomusuReus());
            old.setRecImgvisReus(
                    Objects.nonNull(dto.getRecImgvisReus()) && !entity.getRecImgvisReus().isEmpty()
                            ? entity.getRecImgvisReus()
                            : old.getRecImgvisReus());
            old.setRecDirresReus(
                    Objects.nonNull(dto.getRecDirresReus()) && !entity.getRecDirresReus().isEmpty()
                            ? entity.getRecDirresReus()
                            : old.getRecDirresReus());
            old.setRecTelefoReus(
                    Objects.nonNull(dto.getRecTelefoReus()) && !entity.getRecTelefoReus().isEmpty()
                            ? entity.getRecTelefoReus()
                            : old.getRecTelefoReus());
            old.setApjCorreoApgm(
                    Objects.nonNull(dto.getApjCorreoApgm()) && !entity.getApjCorreoApgm().isEmpty()
                            ? entity.getApjCorreoApgm()
                            : old.getApjCorreoApgm());
            old.setSisCodpaiSipa(
                    Objects.nonNull(dto.getSisCodpaiSipa()) && !entity.getSisCodpaiSipa().isEmpty()
                            ? entity.getSisCodpaiSipa()
                            : old.getSisCodpaiSipa());
            old.setSisIdedptSidp(
                    Objects.nonNull(dto.getSisIdedptSidp()) && !entity.getSisIdedptSidp().isEmpty()
                            ? entity.getSisIdedptSidp()
                            : old.getSisIdedptSidp());
            old.setSisCodproSipr(
                    Objects.nonNull(dto.getSisCodproSipr()) && !entity.getSisCodproSipr().isEmpty()
                            ? entity.getSisCodproSipr()
                            : old.getSisCodproSipr());
            old.setRecCodposReus(
                    Objects.nonNull(dto.getRecCodposReus()) && !entity.getRecCodposReus().isEmpty()
                            ? entity.getRecCodposReus()
                            : old.getRecCodposReus());
            old.setRecGeolatReus(
                    Objects.nonNull(dto.getRecGeolatReus()) && !entity.getRecGeolatReus().equals(0)
                            ? entity.getRecGeolatReus()
                            : old.getRecGeolatReus());
            old.setRecGeolonReus(
                    Objects.nonNull(dto.getRecGeolonReus()) && !entity.getRecGeolonReus().equals(0)
                            ? entity.getRecGeolonReus()
                            : old.getRecGeolonReus());
            old.setRecGeolonReus(
                    Objects.nonNull(dto.getRecGeolonReus()) && !entity.getRecGeolonReus().equals(0)
                            ? entity.getRecGeolonReus()
                            : old.getRecGeolonReus());
            old.setSisCountaRkey(
                    Objects.nonNull(dto.getSisCountaRkey()) && !entity.getSisCountaRkey().equals(0)
                            ? entity.getSisCountaRkey()
                            : old.getSisCountaRkey());
            old.setSisCountbRkey(
                    Objects.nonNull(dto.getSisCountbRkey()) && !entity.getSisCountbRkey().equals(0)
                            ? entity.getSisCountbRkey()
                            : old.getSisCountbRkey());
            old.setSisCountcRkey(
                    Objects.nonNull(dto.getSisCountcRkey()) && !entity.getSisCountcRkey().equals(0)
                            ? entity.getSisCountcRkey()
                            : old.getSisCountcRkey());
            old.setSisCountdRkey(
                    Objects.nonNull(dto.getSisCountdRkey()) && !entity.getSisCountdRkey().equals(0)
                            ? entity.getSisCountdRkey()
                            : old.getSisCountdRkey());
            old.setSisCounteRkey(
                    Objects.nonNull(dto.getSisCounteRkey()) && !entity.getSisCounteRkey().equals(0)
                            ? entity.getSisCounteRkey()
                            : old.getSisCounteRkey());
            old.setSisCountfRkey(
                    Objects.nonNull(dto.getSisCountfRkey()) && !entity.getSisCountfRkey().equals(0)
                            ? entity.getSisCountfRkey()
                            : old.getSisCountfRkey());
            old.setRecEstregReus(
                    Objects.nonNull(dto.getRecEstregReus()) && !entity.getRecEstregReus().equals(0)
                            ? entity.getRecEstregReus()
                            : old.getRecEstregReus());

            return  saveResponseTranslate.translate(repository.save(old));

        }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }
    @Override
    public void delete(String id) throws EBusinessException {
        try {
            repository.delete(repository.findById(id).get());
        }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

}

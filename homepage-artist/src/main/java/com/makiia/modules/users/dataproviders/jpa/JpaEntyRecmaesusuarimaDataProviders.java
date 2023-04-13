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

            old.setRec_nroreg_reus(
                    Objects.nonNull(dto.getRec_nroreg_reus()) && !entity.getRec_nroreg_reus().isEmpty()
                    ? entity.getRec_nroreg_reus()
                    : old.getRec_nroreg_reus());
            old.setRec_niknam_reus(
                    Objects.nonNull(dto.getRec_niknam_reus()) && !entity.getRec_niknam_reus().isEmpty()
                            ? entity.getRec_niknam_reus()
                            : old.getRec_niknam_reus());
            old.setRec_nroide_reus(
                    Objects.nonNull(dto.getRec_nroide_reus()) && !entity.getRec_nroide_reus().equals(0)
                            ? entity.getRec_nroide_reus()
                            : old.getRec_nroide_reus());
            old.setRec_nombre_reus(
                    Objects.nonNull(dto.getRec_nombre_reus()) && !entity.getRec_nombre_reus().isEmpty()
                            ? entity.getRec_nombre_reus()
                            : old.getRec_nombre_reus());
            old.setRec_apelid_reus(
                    Objects.nonNull(dto.getRec_apelid_reus()) && !entity.getRec_apelid_reus().isEmpty()
                            ? entity.getRec_apelid_reus()
                            : old.getRec_apelid_reus());
            old.setRec_fecnac_reus(
                    Objects.nonNull(dto.getRec_fecnac_reus()) && !entity.getRec_fecnac_reus().isEmpty()
                            ? entity.getRec_fecnac_reus()
                            : old.getRec_fecnac_reus());
            old.setRec_sexusu_reus(
                    Objects.nonNull(dto.getRec_sexusu_reus()) && !entity.getRec_sexusu_reus().isEmpty()
                            ? entity.getRec_sexusu_reus()
                            : old.getRec_sexusu_reus());
            old.setRec_nomusu_reus(
                    Objects.nonNull(dto.getRec_nomusu_reus()) && !entity.getRec_nomusu_reus().isEmpty()
                            ? entity.getRec_nomusu_reus()
                            : old.getRec_nomusu_reus());
            old.setRec_imgvis_reus(
                    Objects.nonNull(dto.getRec_imgvis_reus()) && !entity.getRec_imgvis_reus().isEmpty()
                            ? entity.getRec_imgvis_reus()
                            : old.getRec_imgvis_reus());
            old.setRec_dirres_reus(
                    Objects.nonNull(dto.getRec_dirres_reus()) && !entity.getRec_dirres_reus().isEmpty()
                            ? entity.getRec_dirres_reus()
                            : old.getRec_dirres_reus());
            old.setRec_telefo_reus(
                    Objects.nonNull(dto.getRec_telefo_reus()) && !entity.getRec_telefo_reus().isEmpty()
                            ? entity.getRec_telefo_reus()
                            : old.getRec_telefo_reus());
            old.setApj_correo_apgm(
                    Objects.nonNull(dto.getApj_correo_apgm()) && !entity.getApj_correo_apgm().isEmpty()
                            ? entity.getApj_correo_apgm()
                            : old.getApj_correo_apgm());
            old.setSis_codpai_sipa(
                    Objects.nonNull(dto.getSis_codpai_sipa()) && !entity.getSis_codpai_sipa().isEmpty()
                            ? entity.getSis_codpai_sipa()
                            : old.getSis_codpai_sipa());
            old.setSis_idedpt_sidp(
                    Objects.nonNull(dto.getSis_idedpt_sidp()) && !entity.getSis_idedpt_sidp().isEmpty()
                            ? entity.getSis_idedpt_sidp()
                            : old.getSis_idedpt_sidp());
            old.setSis_codpro_sipr(
                    Objects.nonNull(dto.getSis_codpro_sipr()) && !entity.getSis_codpro_sipr().isEmpty()
                            ? entity.getSis_codpro_sipr()
                            : old.getSis_codpro_sipr());
            old.setRec_codpos_reus(
                    Objects.nonNull(dto.getRec_codpos_reus()) && !entity.getRec_codpos_reus().isEmpty()
                            ? entity.getRec_codpos_reus()
                            : old.getRec_codpos_reus());
            old.setRec_geolat_reus(
                    Objects.nonNull(dto.getRec_geolat_reus()) && !entity.getRec_geolat_reus().equals(0)
                            ? entity.getRec_geolat_reus()
                            : old.getRec_geolat_reus());
            old.setRec_geolon_reus(
                    Objects.nonNull(dto.getRec_geolon_reus()) && !entity.getRec_geolon_reus().equals(0)
                            ? entity.getRec_geolon_reus()
                            : old.getRec_geolon_reus());
            old.setRec_geolon_reus(
                    Objects.nonNull(dto.getRec_geolon_reus()) && !entity.getRec_geolon_reus().equals(0)
                            ? entity.getRec_geolon_reus()
                            : old.getRec_geolon_reus());
            old.setSis_counta_rkey(
                    Objects.nonNull(dto.getSis_counta_rkey()) && !entity.getSis_counta_rkey().equals(0)
                            ? entity.getSis_counta_rkey()
                            : old.getSis_counta_rkey());
            old.setSis_countb_rkey(
                    Objects.nonNull(dto.getSis_countb_rkey()) && !entity.getSis_countb_rkey().equals(0)
                            ? entity.getSis_countb_rkey()
                            : old.getSis_countb_rkey());
            old.setSis_countc_rkey(
                    Objects.nonNull(dto.getSis_countc_rkey()) && !entity.getSis_countc_rkey().equals(0)
                            ? entity.getSis_countc_rkey()
                            : old.getSis_countc_rkey());
            old.setSis_countd_rkey(
                    Objects.nonNull(dto.getSis_countd_rkey()) && !entity.getSis_countd_rkey().equals(0)
                            ? entity.getSis_countd_rkey()
                            : old.getSis_countd_rkey());
            old.setSis_counte_rkey(
                    Objects.nonNull(dto.getSis_counte_rkey()) && !entity.getSis_counte_rkey().equals(0)
                            ? entity.getSis_counte_rkey()
                            : old.getSis_counte_rkey());
            old.setSis_countf_rkey(
                    Objects.nonNull(dto.getSis_countf_rkey()) && !entity.getSis_countf_rkey().equals(0)
                            ? entity.getSis_countf_rkey()
                            : old.getSis_countf_rkey());
            old.setRec_estreg_reus(
                    Objects.nonNull(dto.getRec_estreg_reus()) && !entity.getRec_estreg_reus().equals(0)
                            ? entity.getRec_estreg_reus()
                            : old.getRec_estreg_reus());
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

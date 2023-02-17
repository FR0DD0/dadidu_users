package com.makiia.crosscutting.persistence.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recmaesusuarima")

public class EntyRecmaesusuarima implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rec_nroreg_reus")
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4129511 (primer commit)
    private String rec_nroreg_reus;

    @Basic(optional = false)
    @Column(name = "rec_niknam_reus")
    private String rec_niknam_reus;

    @Basic(optional = false)
    @Column(name = "rec_nroide_reus")
    private String rec_nroide_reus;

    @Basic(optional = false)
    @Column(name = "rec_nombre_reus")
    private String rec_nombre_reus;

    @Basic(optional = false)
    @Column(name = "rec_apelid_reus")
    private String rec_apelid_reus;

    @Basic(optional = false)
    @Column(name = "rec_fecnac_reus")
    private String rec_fecnac_reus;

    @Basic(optional = false)
    @Column(name = "rec_sexusu_reus")
    private String rec_sexusu_reus;

    @Basic(optional = false)
    @Column(name = "rec_nomusu_reus")
    private String rec_nomusu_reus;

    @Basic(optional = false)
    @Column(name = "rec_imgvis_reus")
    private String rec_imgvis_reus;

    @Basic(optional = false)
    @Column(name = "rec_dirres_reus")
    private String rec_dirres_reus;

    @Basic(optional = false)
    @Column(name = "rec_telefo_reus")
    private String rec_telefo_reus;

    @Basic(optional = false)
    @Column(name = "apj_correo_apgm")
    private String apj_correo_apgm;

    @Basic(optional = false)
    @Column(name = "sis_codpai_sipa")
    private String sis_codpai_sipa;

    @Basic(optional = false)
    @Column(name = "sis_idedpt_sidp")
    private String sis_idedpt_sidp;

    @Basic(optional = false)
    @Column(name = "sis_codpro_sipr")
    private String sis_codpro_sipr;

    @Basic(optional = false)
    @Column(name = "rec_codpos_reus")
    private String rec_codpos_reus;

    @Basic(optional = false)
    @Column(name = "rec_geolat_reus")
    private Float rec_geolat_reus;

    @Basic(optional = false)
    @Column(name = "rec_geolon_reus")
    private Float rec_geolon_reus;

    @Basic(optional = false)
    @Column(name = "sis_counta_rkey")
    private Integer sis_counta_rkey;

    @Basic(optional = false)
    @Column(name = "sis_countb_rkey")
    private Integer sis_countb_rkey;

    @Basic(optional = false)
    @Column(name = "sis_countc_rkey")
    private Integer sis_countc_rkey;

    @Basic(optional = false)
    @Column(name = "sis_countd_rkey")
    private Integer sis_countd_rkey;

    @Basic(optional = false)
    @Column(name = "sis_counte_rkey")
    private Integer sis_counte_rkey;

    @Basic(optional = false)
    @Column(name = "sis_countf_rkey")
    private Integer sis_countf_rkey;

    @Basic(optional = false)
    @Column(name = "rec_estreg_reus")
    private Integer rec_estreg_reus;
<<<<<<< HEAD
=======
=======
    private String recNroregReus;

    @Basic(optional = false)
    @Column(name = "rec_niknam_reus")
    private String recNiknamReus;

    @Basic(optional = false)
    @Column(name = "rec_nroide_reus")
    private String recNroideReus;

    @Basic(optional = false)
    @Column(name = "rec_nombre_reus")
    private String recNombreReus;

    @Basic(optional = false)
    @Column(name = "rec_apelid_reus")
    private String recApelidReus;

    @Basic(optional = false)
    @Column(name = "rec_fecnac_reus")
    private String recFecnacReus;

    @Basic(optional = false)
    @Column(name = "rec_sexusu_reus")
    private String recSexusuReus;

    @Basic(optional = false)
    @Column(name = "rec_nomusu_reus")
    private String recNomusuReus;

    @Basic(optional = false)
    @Column(name = "rec_imgvis_reus")
    private String recImgvisReus;

    @Basic(optional = false)
    @Column(name = "rec_dirres_reus")
    private String recDirresReus;

    @Basic(optional = false)
    @Column(name = "rec_telefo_reus")
    private String recTelefoReus;

    @Basic(optional = false)
    @Column(name = "apj_correo_apgm")
    private String apjCorreoApgm;

    @Basic(optional = false)
    @Column(name = "sis_codpai_sipa")
    private String sisCodpaiSipa;

    @Basic(optional = false)
    @Column(name = "sis_idedpt_sidp")
    private String sisIdedptSidp;

    @Basic(optional = false)
    @Column(name = "sis_codpro_sipr")
    private String sisCodproSipr;

    @Basic(optional = false)
    @Column(name = "rec_codpos_reus")
    private String recCodposReus;

    @Basic(optional = false)
    @Column(name = "rec_geolat_reus")
    private Float recGeolatReus;

    @Basic(optional = false)
    @Column(name = "rec_geolon_reus")
    private Float recGeolonReus;

    @Basic(optional = false)
    @Column(name = "sis_counta_rkey")
    private Integer sisCountaRkey;

    @Basic(optional = false)
    @Column(name = "sis_countb_rkey")
    private Integer sisCountbRkey;

    @Basic(optional = false)
    @Column(name = "sis_countc_rkey")
    private Integer sisCountcRkey;

    @Basic(optional = false)
    @Column(name = "sis_countd_rkey")
    private Integer sisCountdRkey;

    @Basic(optional = false)
    @Column(name = "sis_counte_rkey")
    private Integer sisCounteRkey;

    @Basic(optional = false)
    @Column(name = "sis_countf_rkey")
    private Integer sisCountfRkey;

    @Basic(optional = false)
    @Column(name = "rec_estreg_reus")
    private Integer recEstregReus;
>>>>>>> 1db9f2b (primer commit)
>>>>>>> 4129511 (primer commit)
}

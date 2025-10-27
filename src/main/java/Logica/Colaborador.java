package Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

//@Entity
//@PrimaryKeyJoinColumn(name = "nickname")
@BsonDiscriminator(key = "tipo", value = "Colaborador")
public class Colaborador extends Usuario {

//    @OneToMany(mappedBy = "miColaborador")
    private List<Aporte> misAportes = new ArrayList<>();

    ;

    public Colaborador() {
        //this.misAportes = new ArrayList<>();
    }

    public Colaborador(String nickname, String email, String nombre, String apellido, LocalDate fecNac, String imagen, String contraseña, String imagenWeb) {
        super(nickname, email, nombre, apellido, fecNac, imagen, contraseña, imagenWeb);
        this.misAportes = new ArrayList<>();
    }

    public Aporte createAporte(String titulo, double $aporte, int cantidad, EnumRetorno retorno) {

        if (!misAportes.isEmpty()) {
            for (Aporte mio : misAportes) {
                if (titulo.equals(mio.getTituloMiPropuesta())) {
                    return null;
                }
            }
        }
        Aporte a = new Aporte(this.getNickname(), $aporte, cantidad, retorno);

        return a;
    }

    public Aporte createAporte(String titulo, double $aporte, int cantidad, EnumRetorno retorno, LocalDateTime fecAp) {

        if (!misAportes.isEmpty()) {
            for (Aporte mio : misAportes) {
                if (titulo.equals(mio.getTituloMiPropuesta())) {
                    return null;
                }
            }
        }
        Aporte a = new Aporte(this.getNickname(), $aporte, cantidad, retorno, fecAp);

        return a;
    }

    public void añadirAporte(Aporte a) {
        misAportes.add(a);
    }

//    public List<DataPropuesta> getPropuestas(){
//        List<DataPropuesta> listaPropuestasColas = new ArrayList<>();
//        DataPropuesta DP;
//        for(Aporte a: misAportes){
//            DP = a.getDataPropuesta();
//            if(DP != null)
//                listaPropuestasColas.add(a.getDataPropuesta());
//        }
//        return listaPropuestasColas;
//    }
    public List<String> getTituloPropuestas() {
        List<String> listaPropuestas = new ArrayList<>();
        for (Aporte a : this.misAportes) {
            listaPropuestas.add(a.getTituloMiPropuesta());
        }
        return listaPropuestas;
    }

    public List<String> getTituloNickPropuestas() {
        List<String> listaPropuestas = new ArrayList<>();
        for (Aporte a : this.misAportes) {
            listaPropuestas.add(a.getTituloNickMiPropuesta());
        }
        return listaPropuestas;
    }

    public DataAporte getDataAporte(String tituloNick) {
        for (Aporte a : misAportes) {
            if (tituloNick.equals(a.getTituloNickMiPropuesta())) {
                return new DataAporte(a.get$aporte(), a.getFechaHora(), a.getCantidad(), a.getRetorno(), a.getNickMiColaborador(), a.getTituloMiPropuesta(), a.getImagenMiPropuesta(), a.getNecesaria());
            }
        }
        return null;
    }

    public Aporte getAporte(String tituloNick) {
        for (Aporte a : misAportes) {
            if (tituloNick.equals(a.getTituloNickMiPropuesta())) {
                return a;
            }
        }
        return null;
    }

    public Aporte borrarAporte(String tituloNick) {
        for (Aporte a : misAportes) {
            if (tituloNick.equals(a.getTituloNickMiPropuesta())) {
                //a.desvincular();
                misAportes.remove(a);
                return a;
            }
        }
        return null;
    }

    public List<Aporte> getMisAportes() {
        return misAportes;
    }

    public void setMisAportes(List<Aporte> misAportes) {
        this.misAportes = misAportes;
    }

}

import Entidades.Pais;
import Entidades.*;
import Repositorios.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //	Crear un país ( Argentina).
        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();

        //	Crear una provincia relacionarla con el país (Buenos Aires).
        Provincia buenosAires = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();
        argentina.getProvincias().add(buenosAires);

        //Crear 1 localidad de Buenos Aires, estableciendo su relación ( Caba ).
        Localidad caba = Localidad.builder()
                .nombre("caba")
                .id(1L)
                .build();
        //-	Crear un domicilio para Caba
        Domicilio domicilio1 = Domicilio.builder()
                .id(1L)
                .calle("Calle 1")
                .numero(440)
                .cp(6608)
                .localidad(caba)
                .build();

        //	Crear otra localidad de Buenos Aires, estableciendo su relación ( La Plata ).
        Localidad laPlata = Localidad.builder()
                .nombre("La Plata")
                .id(1L)
                .build();
        //-	Crear un domicilio para La Plata
        Domicilio domicilio2 = Domicilio.builder()
                .id(1L)
                .calle("Calle 2")
                .numero(745)
                .codigoPostal(6608)
                .localidad(laPlata)
                .build();

        //	Crear otra provincia relacionarla con el país (Córdoba).
        Provincia cordoba = Provincia.builder()
                .nombre("Cordoba")
                .id(1L)
                .pais(argentina)
                .build();
        argentina.getProvincias().add(cordoba);
        //Crear 1 localidad de Córdoba, estableciendo su relación ( Córdoba Capital ).
        Localidad cordobaCapital = Localidad.builder()
                .id(1L)
                .nombre("Cordoba Capital")
                .provincia(cordoba)
                .build();
        Domicilio domicilio3 = Domicilio.builder()
                .calle("Calle1")
                .id(1L)
                .numero(112)
                .codigoPostal(6608)
                .localidad(cordobaCapital)
                .build();

        //Crear otra  localidad de Córdoba, estableciendo su relación ( Villa Carlos Paz ).
        Localidad villaCarlosPaz = Localidad.builder()
                .id(1L)
                .nombre("Villa Carlos Paz")
                .provincia(cordoba)
                .build();
        //Crear un domicilio para Villa Carlos Paz.
        Domicilio domicilio4 = Domicilio.builder()
                .calle("Calle2")
                .id(1L)
                .numero(112)
                .localidad(villaCarlosPaz)
                .build();

        //	Crear la Sucursal1 y relacionarla con el domicilio de Caba.
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal 1")
                .id(1L)
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(true)
                .domicilio(domicilio1)
                .build();
        //Crear la Sucursal2 y relacionarla con el domicilio de La Plata.
        Sucursal sucursal2 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio2)
                .build();
        //	Crear la Sucursal3 y relacionarla con el domicilio de Córdoba Capital.
        Sucursal sucursal3 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio3)
                .build();
        Sucursal sucursal4 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(12, 30))
                .horarioCierre(LocalTime.of(12, 30))
                .es_Casa_Matriz(false)
                .domicilio(domicilio4)
                .build();


        //Crear la Empresa1 y relacionarlas con la sucursal 1 y 2.
        Empresa empresa1 = Empresa.builder()
                .nombre("empresa1")
                .id(1L)
                .cuit(123456)
                .logo("logo")
                .sucursales(new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();

        //	Crear la Empresa2 y relacionarla con la sucursal 3 y 4.
        Empresa empresa2 = Empresa.builder()
                .nombre("empresa2")
                .id(1L)
                .cuit(723952)
                .logo("logo2")
                .sucursales(new HashSet<>(Set.of(sucursal3, sucursal4)))
                .build();

        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

//        System.out.println(mendoza);
//        System.out.println(argentina);
    }
}
package com.lucarinelli.usersmanager.utility;

import java.time.LocalDate;
import java.util.List;

import com.lucarinelli.usersmanager.model.City;

public class CalcoloCodiceFiscale {
  
    public static String get(String cognome, String nome, String sesso, String cittaNatale, LocalDate dataDiNascita){

        String codiceFiscale;

        cognome = cognome.toUpperCase();
        nome = nome.toUpperCase();
        sesso = sesso.toUpperCase();
        cittaNatale = cittaNatale.toUpperCase();

        // Prima parte con il cognome
        String part1;

        if (cognome.length() < 3){
            cognome = cognome + "X";
        }
        String consonanti = cognome.replaceAll("[A,E,I,O,U]","");
        String vocali = cognome.replaceAll("[B,C,D,F,G,H,L,M,N,P,Q,R,S,T,V,Z,X,Y,J,K]","");

        part1 = consonanti + vocali;
        part1 = part1.substring(0,3);

        codiceFiscale = part1;

        // Seconda parte con il nome
        String part2;

        if (nome.length() < 3){
            nome = nome + "X";
        }
        consonanti = nome.replaceAll("[A,E,I,O,U]","");
        vocali = nome.replaceAll("[B,C,D,F,G,H,L,M,N,P,Q,R,S,T,V,Z,X,Y,J,K]","");

        if (consonanti.length() >=4 ){
            part2 = consonanti.substring(0, 1) + consonanti.substring(2,4);
        }
        else {
            part2 = consonanti + vocali;
            part2 = part2.substring(0,3);
        }
        codiceFiscale = codiceFiscale + part2;

        // Terza parte
        String data = dataDiNascita.toString();
        String anno = data.split("-")[0];
        String mese = data.split("-")[1];
        String giorno = data.split("-")[2];

        codiceFiscale = codiceFiscale + anno.substring(2);

        switch (mese){
            case "1" :
                codiceFiscale = codiceFiscale + "A";
                break;
            case "2" :
                codiceFiscale = codiceFiscale + "B";
                break;
            case "3" :
            codiceFiscale = codiceFiscale + "C";
                break;
            case "4" :
            codiceFiscale = codiceFiscale + "D";
                break;
            case "5" :
            codiceFiscale = codiceFiscale + "E";
                break;
            case "6" :
            codiceFiscale = codiceFiscale + "H";
                break;
            case "7" :
            codiceFiscale = codiceFiscale + "L";
                break;
            case "8" :
            codiceFiscale = codiceFiscale + "M";
                break;
            case "9" :
            codiceFiscale = codiceFiscale + "P";
                break;
            case "10" :
            codiceFiscale = codiceFiscale + "R";
                break;
            case "11" :
            codiceFiscale = codiceFiscale + "S";
                break;
            case "12" :
            codiceFiscale = codiceFiscale + "T";
                break;
        }

        if (sesso.equals("M")){
            codiceFiscale = codiceFiscale + giorno;
        } 
        else {
           Integer c = Integer.parseInt(giorno);
           c = c+40;
           codiceFiscale = codiceFiscale + c.toString();
        }

        // Quarta parte
        List<City> cityList = CityParser.getCityDb(true);
        for (City i : cityList){
            if (i.getNome().equals(cittaNatale)){
                codiceFiscale = codiceFiscale + i.getCodice();
            }
        }

        return codiceFiscale;
    }
}

package com.francesca.frattini.gymwebsite.utils;

import com.francesca.frattini.gymwebsite.entities.Allenamenti;

public class AllenamentiParser {
    public static Allenamenti parse(String stringa) {
        switch (stringa) {
            case "PERSONAL_TRAINING" -> {
                return Allenamenti.PERSONAL_TRAINING;
            }
            case "ALLENAMENTO_DI_GRUPPO" -> {
                return Allenamenti.ALLENAMENTO_DI_GRUPPO;
            }
            case "PREPARAZ_ATLETICA_PALLAVOLO" -> {
                return Allenamenti.PREPARAZ_ATLETICA_PALLAVOLO;
            }
            case "PREPARAZ_ATLETICA_BASKET" -> {
                return Allenamenti.PREPARAZ_ATLETICA_BASKET;
            }
            case "RIEDUCAZIONE_FUNZIONALE" -> {
                return Allenamenti.RIEDUCAZIONE_FUNZIONALE;
            }
            case "RIATLETIZZAZ_POST_INFORTUNIO" -> {
                return Allenamenti.RIATLETIZZAZ_POST_INFORTUNIO;
            }
            case "ANALISI_BIOMECCANICA_CICLISTI" -> {
                return Allenamenti.ANALISI_BIOMECCANICA_CICLISTI;
            }
            case "GINNASTICA_IN_GRAVIDANZA" -> {
                return Allenamenti.GINNASTICA_IN_GRAVIDANZA;
            }
            case "GINNASTICA_POSTURALE_INDIVIDUALE" -> {
                return Allenamenti.GINNASTICA_POSTURALE_INDIVIDUALE;
            }
            case "GINNASTICA_ADULTI" -> {
                return Allenamenti.GINNASTICA_ADULTI;
            }
            case "GINNASTICA_TERZA_ETA" -> {
                return Allenamenti.GINNASTICA_TERZA_ETA;
            }
            case "OSTEOPATIA_ADULTI" -> {
                return Allenamenti.OSTEOPATIA_ADULTI;
            }
            case "OSTEOPATIA_GRAVIDANZA" -> {
                return Allenamenti.OSTEOPATIA_GRAVIDANZA;
            }
            case "OSTEOPATIA_PEDIATRICA" -> {
                return Allenamenti.OSTEOPATIA_PEDIATRICA;
            }

        }
        return Allenamenti.ALLENAMENTO_DI_GRUPPO;
    }
}

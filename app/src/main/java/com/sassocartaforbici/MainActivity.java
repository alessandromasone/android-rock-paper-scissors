package com.sassocartaforbici;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private TextView computerChoiceTextView;
    private TextView playerChoiceTextView;
    private String[] choices = {"Sasso", "Carta", "Forbici"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inizializzazione delle variabili per i TextView
        resultTextView = findViewById(R.id.resultTextView);
        computerChoiceTextView = findViewById(R.id.computerChoiceTextView);
        playerChoiceTextView = findViewById(R.id.playerChoiceTextView);
    }

    public void onSelectionClick(View view) {
        Button selectionButton = (Button) view;
        String playerChoice = selectionButton.getText().toString();
        String computerChoice = getRandomChoice();

        // Determina il vincitore e ottiene il risultato
        String result = determineWinner(playerChoice, computerChoice);

        // Aggiorna i TextView con le scelte del computer e del giocatore
        computerChoiceTextView.setText("Il computer ha scelto: " + computerChoice);
        playerChoiceTextView.setText("Hai scelto: " + playerChoice);
        resultTextView.setText(result);
    }

    // Genera una scelta casuale per il computer
    private String getRandomChoice() {
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    // Determina il vincitore in base alle scelte del giocatore e del computer
    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Pareggio!";
        } else if ((playerChoice.equals("Sasso") && computerChoice.equals("Forbici")) ||
                (playerChoice.equals("Carta") && computerChoice.equals("Sasso")) ||
                (playerChoice.equals("Forbici") && computerChoice.equals("Carta"))) {
            return "Hai vinto!";
        } else {
            return "Hai perso!";
        }
    }
}


/*

onCreate: Questo metodo viene chiamato quando l'activity viene creata. Qui, vengono inizializzati i vari TextView tramite i loro ID assegnati nel layout XML.

onSelectionClick: Questo metodo viene chiamato quando uno dei pulsanti viene premuto. Ottiene la scelta del giocatore dal pulsante premuto e genera una scelta casuale per il computer. Successivamente, chiama il metodo determineWinner per determinare il vincitore e aggiorna i TextView con le scelte del computer e del giocatore, insieme al risultato.

getRandomChoice: Questo metodo genera una scelta casuale per il computer selezionando un elemento casuale dall'array choices.

determineWinner: Questo metodo confronta le scelte del giocatore e del computer per determinare il vincitore. Restituisce una stringa che rappresenta il risultato del gioco.

 */

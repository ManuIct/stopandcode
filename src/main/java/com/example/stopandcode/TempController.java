package com.example.stopandcode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TempController {

    @GetMapping("/index")
    public String converti(@RequestParam(name="temp", required = false, defaultValue = "0") String tempStr, Model model) {

        double celsius;


        String messaggioErrore = null;
        try {

            celsius = Double.parseDouble(tempStr.replace(",", "."));
        } catch (Exception e) {
            messaggioErrore = "Errore '" + tempStr + "' non è un numero. Inserisci un valore numerico.";
            celsius = 0;

        }


        double fahrenheit = (celsius * 9 / 5.0) + 32;
        double kelvin = celsius + 273.15;


        model.addAttribute("celsius", celsius);
        model.addAttribute("fahrenheit", String.format("%.2f", fahrenheit));
        model.addAttribute("kelvin", String.format("%.2f", kelvin));
        model.addAttribute("errore", messaggioErrore);

        return "index";
    }
}
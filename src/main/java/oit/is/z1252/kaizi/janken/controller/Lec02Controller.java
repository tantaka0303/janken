package oit.is.z1252.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lec02Controller {
  @GetMapping("/lec02")
  public String lec02(@RequestParam Integer hand, ModelMap model) {
    String Hand;
    String CPU = "相手の手 Gu";
    String kekka;
    if (hand == 0) {
      Hand = "あなたの手 Gu";
      kekka = "Aiko";
      model.addAttribute("Hand", Hand);
      model.addAttribute("CPU", CPU);
      model.addAttribute("kekka", kekka);
    }
    if (hand == 1) {
      Hand = "あなたの手 Choki";
      kekka = "You Lose!";
      model.addAttribute("Hand", Hand);
      model.addAttribute("CPU", CPU);
      model.addAttribute("kekka", kekka);
    }
    if (hand == 2) {
      Hand = "あなたの手 Pa";
      kekka = "You Win!";
      model.addAttribute("Hand", Hand);
      model.addAttribute("CPU", CPU);
      model.addAttribute("kekka", kekka);
    }
    return "lec02.html";
  }

  @PostMapping("/lec02")
  public String lec02(@RequestParam String username, ModelMap model) {
    model.addAttribute("username", username);
    return "lec02.html";
  }
}

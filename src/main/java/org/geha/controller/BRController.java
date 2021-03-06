package org.geha.controller;
/*
  User: Yemao Luo
  Date: 2021/10/22
  Time: 9:26
*/

import org.geha.domain.Equipment;
import org.geha.domain.Msg;
import org.geha.domain.User;
import org.geha.service.BRService;
import org.geha.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/br")
@Controller
public class BRController {

    @Autowired
    private BRService brService;
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/BRCRUDPage")
    public ModelAndView BRCRUDPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/BRCRUD.jsp");
        modelAndView.addObject("NotInUseList", brService.findAllNotInUse());
        modelAndView.addObject("notREquipment", brService.notREquipment((User) session.getAttribute("user")));
        return modelAndView;
    }

    @RequestMapping("/bEquipment")
    public ModelAndView bEquipment(int id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        Msg msg = brService.borrowById(user, id);
        if (msg.getCode()) {
            modelAndView.setViewName("/pages/BRCRUD.jsp");
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setInUse(false);
            equipmentService.updateEquipment(equipment);
            modelAndView.addObject("msg_bEquipment", msg);
            modelAndView.addObject("NotInUseList", brService.findAllNotInUse());
            modelAndView.addObject("notREquipment", brService.notREquipment(user));
            return modelAndView;
        } else {
            modelAndView.addObject("msg_bEquipment", msg);
            modelAndView.setViewName("/pages/BRCRUD.jsp");
            return modelAndView;
        }
    }

    @RequestMapping("/rEquipment")
    public ModelAndView rEquipment(int id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        Msg msg = brService.returnById(user, id);
        modelAndView.addObject("rEquipment", msg);
        modelAndView.addObject("NotInUseList", brService.findAllNotInUse());
        modelAndView.addObject("notREquipment", brService.notREquipment(user));
        modelAndView.setViewName("/pages/BRCRUD.jsp");
        return modelAndView;
    }

    @RequestMapping("/BRList")
    public ModelAndView BRList() {
        ModelAndView modelAndView = new ModelAndView();
        if (brService.checkNull()) {
            modelAndView.addObject("BRList", brService.BRList());
            modelAndView.setViewName("/pages/BRList.jsp");
        } else {
            modelAndView.addObject("BRList", null);
            modelAndView.setViewName("/pages/BRList.jsp");
        }
        return modelAndView;
    }
}

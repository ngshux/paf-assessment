package vttp2022.paf.assessment.eshop.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import vttp2022.paf.assessment.eshop.models.LineItem;

@Controller
public class OrderController {

	//TODO: Task 3
	@PostMapping
	public String postOrder(@RequestBody MultiValueMap<String,String> form, Model model, HttpSession sess){

		List<LineItem> lineItems = (List<LineItem>)sess.getAttribute("order");
        if (null == lineItems) {
            lineItems = new LinkedList<>();
            sess.setAttribute("order", lineItems);
        }

        String item = form.getFirst("item");
        Integer quantity  = Integer.parseInt(form.getFirst("quantity"));

        for (LineItem li: lineItems){
			li.setItem(item);
			li.setQuantity(quantity);
            System.out.printf("name: %s, quantity: %d\n", li.getItem(), li.getQuantity());
		}
        model.addAttribute("lineItems", lineItems);
        
        return "order";
	}
}

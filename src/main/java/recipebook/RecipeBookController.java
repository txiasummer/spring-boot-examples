package recipebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeBookController {
    private static final String type = "vegetarian";

    private RecipeBookRepository repository;

    @Autowired
    public RecipeBookController(RecipeBookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String recipeByType(Model model) {

        List<Recipe> recipes = repository.findByType(type);
        if (recipes != null) {
            model.addAttribute("recipes", recipes);
        }
        return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToType(Recipe recipe) {
        recipe.setType(type);
        repository.save(recipe);
        return "redirect:/recipes";
    }
}

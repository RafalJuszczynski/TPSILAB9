
package wizut.tpsi.lab9;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogPostController {

    @Autowired
    private BlogRepository blogRepository;
    
    @RequestMapping("/")
    public String getPosts(Model model) throws SQLException {
        model.addAttribute("allPosts", blogRepository.getAllPosts());
        return "index";
    }
    
    @PostMapping("/newpost")
        public String newPost(BlogPost post) throws SQLException {
        blogRepository.createPost(post);
        return "redirect:/";
    }
        
    @PostMapping("/deletepost")
    public String newPost(DeleteForm form) throws SQLException {
        blogRepository.deletePost(form.getId());
        return "redirect:/";
    }
}

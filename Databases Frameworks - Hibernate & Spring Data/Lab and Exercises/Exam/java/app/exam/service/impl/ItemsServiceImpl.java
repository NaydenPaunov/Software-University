package app.exam.service.impl;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.domain.entities.Category;
import app.exam.domain.entities.Item;
import app.exam.parser.ValidationUtil;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.CategoryRepository;
import app.exam.repository.ItemsRepository;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ModelParser modelParser;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(ItemJSONImportDTO itemJSONImportDTO) {
        Item item= this.modelParser.convert(itemJSONImportDTO,Item.class);

        String categoryName = itemJSONImportDTO.getCategory();
        Category category = this.categoryRepository.findByName(categoryName);
        if(category != null){
            item.setCategory(category);
        }else if(category == null){
            Category newCategory = new Category();
            newCategory.setName(categoryName);

            if(ValidationUtil.isValid(newCategory)){
                item.setCategory(newCategory);
                if(!ValidationUtil.isValid(item)) {
                    throw new IllegalArgumentException("Item not valid");
                }
                categoryRepository.saveAndFlush(newCategory);
            }else {
                throw new IllegalArgumentException("Category not valid");
            }
        }
        this.itemsRepository.save(item);
    }
}

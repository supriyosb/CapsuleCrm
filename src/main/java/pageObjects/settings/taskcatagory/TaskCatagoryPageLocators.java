package pageObjects.settings.taskcatagory;

import org.openqa.selenium.By;

public class TaskCatagoryPageLocators {

    /**
     * Constructor
     * It will initialize TaskCatagoryPageLocators instance
     */
    public TaskCatagoryPageLocators() {
    }

    By linkAddTaskCategory = By.linkText("Add new Category");
    By txtName = By.id("editCategoryForm:taskCategoryNameDecorate:taskCategoryName");
    By btnSave = By.xpath("//input[@value='Save']");
    String dynLinkCatagoryDelete = "//a[text()='$category$']/parent::td/following-sibling::td//a[text()='Delete']";
    By btnDeleteConf = By.xpath("//input[@value='Delete category']");
    By deletePopup = By.id("deleteCategoryModal");
}

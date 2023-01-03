package ru.wilddisk.practicefx.controller

import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import ru.wilddisk.practicefx.model.Employee
import java.net.URL
import java.util.*

class EmployeeController : Initializable {
    @FXML
    private lateinit var treeTableView: TreeTableView<Employee>
    @FXML
    private lateinit var empNoCol: TreeTableColumn<Employee, String>
    @FXML
    private lateinit var firstNameCol: TreeTableColumn<Employee, String>
    @FXML
    private lateinit var lastNameCol: TreeTableColumn<Employee, String>
    @FXML
    private lateinit var genderCol: TreeTableColumn<Employee, String>
    @FXML
    private lateinit var positionCol: TreeTableColumn<Employee, String>
    @FXML
    private lateinit var singleCol: TreeTableColumn<Employee, Boolean>
    @FXML
    private lateinit var fullNameCol: TreeTableColumn<Employee, String>



    private val itel_l1 = TreeItem<String>("Nasm")
    private val itel_l2 = TreeItem<String>("ASM")
    private val parent = TreeItem<String>("Low level")

    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private lateinit var btm: Button

    val empBoss = Employee("E00", "Abc@gmail.com","Boss", "Boss", "Manager", "M", false)
    val empSmith = Employee("E01", "Smith@gmail.com", "Susan", "Smith", "Salesman", "F", true)
    val empMcNeil = Employee("E02", "McNeil@gmail.com", "Anne", "McNeil", "Cleck", "M", false)

    val empBoss1 = Employee("E10", "Abc@gmail.com","Boss", "Boss", "Manager", "M", false)
    val empSmith1 = Employee("E11", "Smith@gmail.com", "Susan", "Smith", "Salesman", "F", true)
    val empMcNeil1 = Employee("E12", "McNeil@gmail.com", "Anne", "McNeil", "Cleck", "M", false)

    val itemRoot = TreeItem<Employee>(empBoss)
    val itemSmith = TreeItem<Employee>(empSmith)
    val itemMcNeil = TreeItem<Employee>(empMcNeil)

    val itemRoot1 = TreeItem<Employee>(empBoss1)
    val itemSmith1 = TreeItem<Employee>(empSmith1)
    val itemMcNeil1 = TreeItem<Employee>(empMcNeil1)

    @FXML
    private fun onHelloButtonClick() {
//        itemRoot.children.add(TreeItem(Employee("1", "aa@aa.aa", "a", "a", "1", "a", false)))
        welcomeText.text = treeTableView.selectionModel.selectedItem.value.toString()
    }

    @FXML
    private fun callOnT() {

    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        empNoCol.setCellValueFactory { SimpleObjectProperty(it.value.value.empNo) }
        firstNameCol.setCellValueFactory { SimpleObjectProperty(it.value.value.firstName) }
        lastNameCol.setCellValueFactory { SimpleObjectProperty(it.value.value.lastName) }
        positionCol.setCellValueFactory { SimpleObjectProperty(it.value.value.position) }
        genderCol.setCellValueFactory { SimpleObjectProperty(it.value.value.gender) }
        singleCol.setCellValueFactory { SimpleObjectProperty(it.value.value.single) }



        itemRoot.children.setAll(itemSmith, itemMcNeil)
        itemRoot1.children.setAll(itemSmith1, itemMcNeil1)

        val root = TreeItem<Employee>(Employee("Employees", "", "", "", "", "", false))

        root.children.addAll(itemRoot, itemRoot1)
        treeTableView.root = root
    }
}
package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.io.IOException;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CartController {

    private Store store;
    private Cart cart;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            refreshTable();
            updateTotalCost();
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/ViewStore.fxml"));
            Parent root = fxmlLoader.load();
            ViewStoreController controller = fxmlLoader.getController();
            controller.setData(store, cart);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.getItemsOrdered().clear();
        refreshTable();
        updateTotalCost();
    }

    private void applyFilter(String filterText) {
        if (filterText == null) filterText = "";
        String lowerFilter = filterText.toLowerCase();

        RadioButton selectedRadio = (RadioButton) filterCategory.getSelectedToggle();
        String selectedFilter = selectedRadio != null ? selectedRadio.getText() : "By Title";

        tblMedia.setItems(FXCollections.observableArrayList(
            cart.getItemsOrdered().stream()
                .filter(media -> {
                    if (selectedFilter.equalsIgnoreCase("By ID")) {
                        return Integer.toString(media.getId()).contains(lowerFilter);
                    } else {
                        return media.getTitle().toLowerCase().contains(lowerFilter);
                    }
                })
                .collect(Collectors.toList())
        ));
    }

    private void refreshTable() {
        applyFilter(tfFilter.getText());
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    void updateTotalCost() {
        float total = 0f;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        costLabel.setText(String.format("Total Cost: $%.2f", total));
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        if (cart != null && cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
            updateTotalCost();
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> {
            applyFilter(newVal);
        });

        filterCategory.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            applyFilter(tfFilter.getText());
        });
    }
}

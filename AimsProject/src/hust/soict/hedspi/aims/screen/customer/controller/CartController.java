package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
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

import java.io.IOException;
import java.util.stream.Collectors;

public class CartController {

    private Store store;
    private Cart cart;

    public CartController() {}

    public void setData(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        if (tblMedia != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        updateTotalCost();
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
    void btnPlayPressed(ActionEvent event) {
        if (tblMedia == null) return;
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                showAlert("Playback Error", e.getMessage());
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        if (tblMedia == null) return;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
            Parent root = fxmlLoader.load();
            ViewStoreController controller = fxmlLoader.getController();
            controller.setData(store, cart);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Cannot load store view.");
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

        String selectedFilter = "By Title";
        Toggle selectedToggle = filterCategory.getSelectedToggle();
        if (selectedToggle != null && selectedToggle instanceof RadioButton) {
            selectedFilter = ((RadioButton) selectedToggle).getText();
        }

        String filter = selectedFilter;

        tblMedia.setItems(FXCollections.observableArrayList(
            cart.getItemsOrdered().stream()
                .filter(media -> {
                    if (filter.equalsIgnoreCase("By ID")) {
                        return Integer.toString(media.getId()).contains(lowerFilter);
                    } else {
                        return media.getTitle().toLowerCase().contains(lowerFilter);
                    }
                })
                .collect(Collectors.toList())
        ));
    }

    private void refreshTable() {
        if (tfFilter != null) {
            applyFilter(tfFilter.getText());
        }
    }

    void updateButtonBar(Media media) {
        if (btnPlay == null || btnRemove == null) return;

        btnRemove.setVisible(media != null);
        btnPlay.setVisible(media instanceof Playable);
    }

    void updateTotalCost() {
        if (costLabel == null || cart == null) return;

        float total = 0f;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        costLabel.setText(String.format("Total Cost: $%.2f", total));
    }

    @FXML
    public void initialize() {
        if (colMediaId != null) colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        if (colMediaTitle != null) colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        if (colMediaCategory != null) colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        if (colMediaCost != null) colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        if (btnPlay != null) btnPlay.setVisible(false);
        if (btnRemove != null) btnRemove.setVisible(false);

        if (tblMedia != null) {
            tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    updateButtonBar(newValue);
                }
            });
        }

        if (tfFilter != null) {
            tfFilter.textProperty().addListener((obs, oldVal, newVal) -> applyFilter(newVal));
        }

        if (filterCategory != null) {
            filterCategory.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
                if (tfFilter != null) applyFilter(tfFilter.getText());
            });
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

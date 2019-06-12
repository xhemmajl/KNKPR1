package main;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

public class I18N {
	public static ObjectProperty<Locale> locale;
	
	static {
		locale = new SimpleObjectProperty<>(getDefaultLocale());
	}
	
	public static List<Locale> getLanguages(){
		return new ArrayList<Locale>(Arrays.asList(Locale.ENGLISH, new Locale("al","AL")));
	}
	
	public static Locale getDefaultLocale() {
		return Locale.ENGLISH;
	}
	
	public static Locale getLocale() {
		return locale.get();
	}
	
	public static void setLocale(Locale locale) {
		localeProperty().set(locale);
	}
	
	public static ObjectProperty<Locale> localeProperty(){
		return locale;
	}
	
	public static String get(String key, Object... args) {
		
		ResourceBundle bundle = ResourceBundle.getBundle("main.translates.translate",getLocale());
		
		
		
		
		return MessageFormat.format(bundle.getString(key), args);
		
	}
	
	public static StringBinding createStringBinding(String key, Object...args) {
		
		return Bindings.createStringBinding(()->get(key,args),locale);
	}
	
	
	public static Label getLabel(String key, Object... args) {
		Label label = new Label();
		label.textProperty().bind(createStringBinding(key, args));
		
		return label;
	}
	
	public static Button getButton(String key,Object... args) {
		Button button = new Button();
		button.textProperty().bind(createStringBinding(key,args));
		
		return button;
	}
	
	public static Hyperlink getHyperlink(String key,Object... args) {
		Hyperlink hyperlink = new Hyperlink();
		hyperlink.textProperty().bind(createStringBinding(key,args));
		
		return hyperlink;
	}
	
	public static CheckBox getCheckBox(String key,Object... args) {
		CheckBox checkBox = new CheckBox();
		checkBox.textProperty().bind(createStringBinding(key,args));
		
		return checkBox;
	}
	
	public static RadioButton getRadioButton(String key,Object... args) {
		RadioButton radioButton = new RadioButton();
		radioButton.textProperty().bind(createStringBinding(key,args));
		
		return radioButton;
	}
	
	public static Menu getMenu(String key,Object... args) {
		Menu menu = new Menu();
		menu.textProperty().bind(createStringBinding(key, args));
		
		return menu;
	}
	
	public static MenuItem getMenuItem(String key,Object... args) {
		MenuItem menuItem = new MenuItem();
		menuItem.textProperty().bind(createStringBinding(key, args));
		
		return menuItem;
	}
	
	
}

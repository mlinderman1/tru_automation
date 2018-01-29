package lib;

public class Selectors {

  public static final String page = ".page-layout";

  // Homepage
  public static final String btn__lightbox__close = ".truEventLightboxClose";  //Proposed new lightbox id after 10/28/17

  // Top Line Header

  public static final String btn__topline__logo__TRU = ".top-line-header__logo.top-line-header__logo-bru";
  public static final String btn__topline__logo__BRU = ".top-line-header__logo.top-line-header__logo-tru";
  public static final String link__topline__registry = ".top-line-header__menu__item.menu__baby-registry";
  public static final String link__topline__find_a_store = ".top-line-header__menu__item.menu__find-a-store";
  public static final String link__topline__weekly_ad = ".top-line-header__menu__item.menu__weekly-ad";
  public static final String link__topline__wishlist = ".top-line-header__menu__item.menu__wish-list";
  public static final String link__topline__gift_card = ".top-line-header__menu__item.menu__gift-cards";

  // Global Nav
  public static final String btn__main__TRU_logo = ".header-fat__logo.header-fat__logo-tru";
  public static final String btn__main__BRU__logo = ".header-fat__logo.header-fat__logo-bru";

  public static final String input__global_nav__search_field = "#search-input";

  public static final String btn__global_nav__my_account = ".header-fat__tile.header-fat__tile-my-account";
  public static final String dropdown__global_nav__my_account = ".header-fat-my-account__desktop";

  public static final String btn__global_nav__help = ".tru-dropdown.help-tile";
  public static final String link__global_nav__help__help_center = ".help-tile__submenu-item-link";
  public static final String btn__global_nav__help__moxie_online = ".help-tile__submenu-item--moxie";
  public static final String btn__global_nav__help__moxie_offline = ".help-tile__submenu-item--moxie--disabled";

  public static final String btn_global_nav__minicart = ".header-fat__tile.header-fat__tile-cart";

  // PLP Page
  public static final String container__page__plp = ".webstore-plp-page";
  public static final String container__plp_grid = ".tru-product-grid__list";
  public static final String container__plp_item = ".product-item";
  public static final String container__plp_item__non_OOS = ".product-item__btn-group";
  public static final String container__plp_item__OOS = ".product-item--out";
  public static final String btn__plp__item = ".product-item__product-button";
  public static final String btn__plp_item__OOS = ".product-item__out-of-stock";

  // Flyout/Side panels
  public static final String btn__flyout__close =".tru-modal-dialog__close-btn";


  // PDP Page
  public static final String container__page__pdp = ".pdp-page-container";
  public static final String btn__pdp__add_to_cart = ".tru-product-actions__primary-button";
  public static final String link__pdp__ispu = ".product-ship-to-store__status-ispu a";


  //Add to Cart
  public static final String btn__add_to_cart = "//button/span[text()='add to cart']";
  public static final String btn__ispu = ".product-item__button-ispu";
  public static final String btn__view_details = "//button/span[text()='view details']";
  public static final String btn__ship_to_store = "//button/span[text()='ship free to store']";
  public static final String btn__preorder = "//button/span[text()='pre-order now']";
  public static final String btn__add_to_registry = "//button/span[text()='add to registry'][0]";
  public static final String btn__add_to_wishlist = "//button/span[text()='add to wish list'][0]";

  public static final String overlay__add_to_cart = ".atc-overlay";

  // ISPU / Store Locator Modal
  public static final String container__ispu = ".ispu-modal";
  public static final String btn__ispu__pickup = ".pickup-btn";
  public static final String btn__ispu__make_store = ".ispu-stores-list__item-link";
  public static final String dropdown__ispu__distance = ".ispu-find-store-form__distance-select";
  public static final String dropdown__ispu__distance_option = ".ispu-find-store-form__distance-select option";

  // Cart
  public static final String container__page__cart = ".checkout-cart-page";
  public static final String btn__checkout_standard__top = "#cart_page_top_checkout";
  public static final String btn__checkout_standard__bottom = "#cart-top-section__checkout-button";
  public static final String btn__checkout_PayPal = ".order-summary-payment-buttons__paypal-button";


  public static final String radiobtn__gift = ".product-gifting__checkbox";
  public static final String radiobtn__gift_checked = ".custom-control-input--checked";


  //Checkout


  // Order Confirmation
  public static final String container__page__order_confirmation = "#nongoodbye_order_confirmation";
  public static final String text__order_confirmation_number = ".checkout-order-complete-header__subheader--bold";


}

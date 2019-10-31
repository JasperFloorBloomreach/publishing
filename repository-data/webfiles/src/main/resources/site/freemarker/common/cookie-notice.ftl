<#include "include/imports.ftl">

<@hst.link var="cookieprefslink" siteMapItemRefId="cookies"/>

<div id="cookie-notice" class="ds_notification  js-initial-cookie-content  fully-hidden">
    <div class="ds_wrapper">
        <div class="ds_notification__content">
            <div class="ds_notification__text">
                <p>We use cookies to make the site simpler.</p>
            </div>

            <div class="ds_notification__actions">
                <button class="ds_button  js-accept-cookies" data-banner="banner-cookie-accept">Accept cookies</button>
                <#if cookieprefslink??>
                    <a href="${cookieprefslink}" class="ds_button  ds_button--secondary" data-banner="banner-cookie-settings">Cookie settings</a>
                </#if>
            </div>
        </div>
    </div>
</div>

<div id="cookie-confirm" class="ds_notification  ds_notification--positive  ds_reversed  js-confirm-cookie-content  fully-hidden">
    <div class="ds_wrapper">
        <div class="ds_notification__content">
            <div class="ds_notification__text">
                <p>
                    Your cookie settings have been saved.
                    <#if cookieprefslink??>
                        <a href="${cookieprefslink}" data-banner="banner-cookie-settings">Turn cookies on or off</a>
                    </#if>
                </p>
            </div>
        </div>
    </div>
</div>

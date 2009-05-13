PRODUCT_PACKAGES := \
	PlatformLibraryClient \
	com.example.android.platform_library \
	libplatform_library_jni

PRODUCT_COPY_FILES := \
    vendor/sample/frameworks/PlatformLibrary/com.example.android.platform_library.xml:system/etc/permissions/com.example.android.platform_library.xml

PRODUCT_SDK_ADDON_NAME := platform_library

PRODUCT_SDK_ADDON_COPY_FILES := \
    vendor/sample/sdk_addon/hardware.ini:hardware.ini \
    vendor/sample/sdk_addon/manifest.ini:manifest.ini


# Add this to PRODUCT_SDK_ADDON_COPY_FILES to copy the files for an
# emulator skin (or for samples)
#    $(call find-copy-subdir-files,*,development/emulator/skins/HVGA,skins/HVGA)

PRODUCT_SDK_ADDON_COPY_MODULES := \
    com.example.android.platform_library:libs/platform_library.jar

PRODUCT_SDK_ADDON_DOC_MODULE := platform_library

$(call inherit-product, $(SRC_TARGET_DIR)/product/sdk.mk)

# Overrides
PRODUCT_NAME := sample_addon

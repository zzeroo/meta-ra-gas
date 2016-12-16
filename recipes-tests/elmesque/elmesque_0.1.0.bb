inherit cargo

SUMMARY = "CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "ELM_LICENSE"
LIC_FILES_CHKSUM = "file://ELM_LICENSE.md;md5=a5d1d029856c5884498834e1a856f48e"

SRC_URI = "gitsm://github.com/mitchmindtree/elmesque.git;protocol=https"

SRCREV = "aef4ec6b478b21b369061dcaaa4485ec4262670b"
PR = "r1"

S = "${WORKDIR}/git"

# # Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

cargo_do_compile_append() {
    export CC="${WRAPPER_DIR}/cc-wrapper.sh"
    export PKG_CONFIG_ALLOW_CROSS="1"
    cargo build ${CARGO_BUILD_FLAGS} --example graphics
}

cargo_do_install_append() {
    install -Dm0644 "${WORKDIR}/target/debug/examples/graphics" "${D}${bindir}"
}

inherit cargo

SUMMARY = "Serverteil der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server.git;branch=master;protocol=https"
SRCREV = "${AUTOREV}"
PV = "git-${SRCPV}"
PR = "r0"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"
RDEPENDS_${PN} += "gtk+3 libmodbus"

cargo_do_compile_append() {
    export CC="${WRAPPER_DIR}/cc-wrapper.sh"
    export PKG_CONFIG_ALLOW_CROSS="1"
    bbnote "which rustc:" `which rustc`
    bbnote "rustc --version" `rustc --version`
    bbnote "which cargo:" `which cargo`
    bbnote "cargo --version" `cargo --version`
    bbnote cargo build ${CARGO_BUILD_FLAGS}
    cargo build --example configuration_to_json ${CARGO_BUILD_FLAGS}
}

# do_install_append() {
#   install -Dm 0755 ${WORKDIR}/target/production/examples/configuration_to_json ${D}/usr/local/bin/
# }

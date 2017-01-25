inherit cargo

SUMMARY = "rustup: the Rust toolchain installer"
HOMEPAGE = "https://github.com/rust-lang-nursery/rustup.rs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  gitsm://github.com/rust-lang-nursery/rustup.rs.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
PV = "git-${SRCPV}"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

# DEPENDS = ""
# RDEPENDS_${PN} += ""

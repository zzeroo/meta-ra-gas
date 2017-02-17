inherit cargo

SUMMARY = "Test backtrace-rs"
HOMEPAGE = "https://github.com/zzeroo/backtrace-rs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SRC_URI = " \
  gitsm://github.com/zzeroo/backtrace-rs.git;branch=objcopy;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PR = "r2"

# Disable do_install()
do_install() {
  true
}

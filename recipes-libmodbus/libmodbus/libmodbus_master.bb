SUMMARY = "libmodbus - a fast and portable Modbus library"
HOMEPAGE = "http://libmodbus.org"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=4fbd65380cdd255951079008b364516c \
                    file://tests/LICENSE;md5=9d793911062ac2215b80ebb5899aec14"
SRC_URI = " \
  gitsm://github.com/stephane/libmodbus.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PR = "r0"

inherit autotools

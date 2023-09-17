import React from 'react'
import Footer from './footer'
import Header from './Header'

const Layout = (children) => {
  return (
    <div>
      <Header />
      <main style={{ minHeight: '70vh' }}>{children}</main>
      <Footer />
    </div>
  )
}

export default Layout

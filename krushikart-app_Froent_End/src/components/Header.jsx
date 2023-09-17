import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import React from 'react'
import NavDropdown from 'react-bootstrap/NavDropdown'
import { LinkContainer } from 'react-router-bootstrap'
import { useAuth } from '../context/auth'
import { toast, Toaster } from 'react-hot-toast'
import { useNavigate } from 'react-router-dom'
import { useCart } from '../context/Cart'
import { Badge } from 'antd'

function BasicExample() {
  const [auth, setAuth] = useAuth()
  const [cart] = useCart()
  const navigate = useNavigate()
  // const role = auth.user.userRole

  const handleLogout = () => {
    setAuth({
      ...auth,
      user: null,
      token: '',
    })
    localStorage.removeItem('auth')
    localStorage.removeItem('userName')
    localStorage.removeItem('loggedIn')
    localStorage.removeItem('user')
    navigate('/')
    toast.success('Logout Successfully')
  }
  return (
    <Navbar bg="dark" expand="lg" variant="dark" collapseOnSelect>
      {/* // <Navbar id="nabar" className="text-white" collapseOnSelect> */}
      <Container>
        <LinkContainer to="/">
          <Navbar.Brand>
            {' '}
            <image
            // src="images/krushikart logo.png"
            />{' '}
            🛒KrishiKart
          </Navbar.Brand>
        </LinkContainer>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <LinkContainer to="/">
              <Nav.Link>
                <i className="fas fa-home"></i>
                &nbsp; Home
              </Nav.Link>
            </LinkContainer>

            <NavDropdown title="Categories" id="basic-nav-dropdown">
              <NavDropdown.Item href="/api/prod/Seeds">Seeds</NavDropdown.Item>
              <NavDropdown.Item href="/api/prod/Fertilizers">
                Fertilizers
              </NavDropdown.Item>
              <NavDropdown.Item href="/api/prod/Machineries">
                Machineries
              </NavDropdown.Item>
            </NavDropdown>

            <LinkContainer to="/contactpage">
              <Nav.Link>
                <i className="fas fa-contact-us"></i>
                Contact Us
              </Nav.Link>
            </LinkContainer>

            {/* <LinkContainer to="/api/auth/user/signup">
              <Nav.Link>&nbsp; Register</Nav.Link>
            </LinkContainer>

            <LinkContainer to="/api/auth/signIn">
              <Nav.Link>
                <i className="fas fa-shopping-user"></i>
                &nbsp;{' '}
                {localStorage.getItem('loggedIn') === 'true'
                  ? localStorage.getItem('userName')
                  : 'SignIn'}
              </Nav.Link>
            </LinkContainer> */}

            {!auth.user ? (
              <>
                <LinkContainer to="/api/auth/user/signup">
                  <Nav.Link>&nbsp; Register</Nav.Link>
                </LinkContainer>

                <LinkContainer to="/api/auth/signin">
                  <Nav.Link>
                    <i className="fas fa-shopping-user"></i>
                    &nbsp;{' '}
                    {localStorage.getItem('loggedIn') === 'true'
                      ? localStorage.getItem('userName')
                      : 'SignIn'}
                  </Nav.Link>
                </LinkContainer>
              </>
            ) : (
              <>
                {auth.user.userRole === 'ROLE_ADMIN' ? (
                  <NavDropdown title={localStorage.getItem('userName')}>
                    <LinkContainer to="/admindashboard">
                      <NavDropdown.Item>Dashboard</NavDropdown.Item>
                    </LinkContainer>
                    <NavDropdown.Item onClick={handleLogout}>
                      Logout
                    </NavDropdown.Item>
                  </NavDropdown>
                ) : (
                  <NavDropdown title={localStorage.getItem('userName')}>
                    <LinkContainer to="/sellerdashboard">
                      <NavDropdown.Item>Dashboard</NavDropdown.Item>
                    </LinkContainer>
                    <NavDropdown.Item onClick={handleLogout}>
                      Logout
                    </NavDropdown.Item>
                  </NavDropdown>
                )}
                {/* 
                <NavDropdown title={localStorage.getItem('userName')}>
                  <LinkContainer to="/sellerbashboard">
                    <NavDropdown.Item>Dashboard</NavDropdown.Item>
                  </LinkContainer>
                  <NavDropdown.Item onClick={handleLogout}>
                    Logout
                  </NavDropdown.Item>
                </NavDropdown> */}
                {/* <LinkContainer to="/api/auth/signin">
                  <Nav.Link onClick={handleLogout}>&nbsp; LogOut</Nav.Link>
                </LinkContainer> */}
              </>
            )}

            <LinkContainer to="/cart">
              <Nav.Link>
                <i className="fas fa-shopping-cart"></i>
                Cart
                <Badge count={cart?.length} showZero offset={[10, -5]}></Badge>
                {/* Cart {cart?.length} */}
              </Nav.Link>
            </LinkContainer>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  )
}

export default BasicExample

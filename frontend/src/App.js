import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import { AppBar, Toolbar, Typography, Container, Button, CssBaseline, Drawer, List, ListItem, ListItemText, IconButton, Box, ThemeProvider, createTheme, Divider } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import Home from './pages/Home';
import City from './pages/City';
import Place from './pages/Place';
import Suggestions from './pages/Suggestions';
import axios from 'axios';

const theme = createTheme({
  palette: {
    mode: 'light',
    primary: { main: '#1976d2' },
    background: { default: '#f5f6fa' },
  },
  typography: {
    fontFamily: 'Roboto, Arial',
  },
});

function AppContent() {
  const [drawerOpen, setDrawerOpen] = useState(false);
  const [cities, setCities] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8080/api/cities').then(res => setCities(res.data));
  }, []);

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar position="fixed" sx={{ zIndex: 1201 }}>
        <Toolbar>
          <IconButton color="inherit" edge="start" onClick={() => setDrawerOpen(true)} sx={{ mr: 2 }}>
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component={Link} to="/" sx={{ flexGrow: 1, color: 'inherit', textDecoration: 'none' }}>
            CityPedia
          </Typography>
          <Button color="inherit" component={Link} to="/suggestions">Suggestions</Button>
        </Toolbar>
      </AppBar>
      <Drawer anchor="left" open={drawerOpen} onClose={() => setDrawerOpen(false)}>
        <Box sx={{ width: 250 }} role="presentation" onClick={() => setDrawerOpen(false)}>
          <Typography variant="h6" sx={{ m: 2 }}>Cities</Typography>
          <Divider />
          <List>
            {cities.map(city => (
              <ListItem button key={city.id} onClick={() => navigate(`/city/${city.id}`)}>
                <ListItemText primary={city.name} />
              </ListItem>
            ))}
          </List>
        </Box>
      </Drawer>
      <Box component="main" sx={{ flexGrow: 1, p: 3, mt: 8 }}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/city/:cityId" element={<City />} />
          <Route path="/place/:placeId" element={<Place />} />
          <Route path="/suggestions" element={<Suggestions />} />
        </Routes>
      </Box>
    </Box>
  );
}

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Router>
        <AppContent />
      </Router>
    </ThemeProvider>
  );
}

export default App;
